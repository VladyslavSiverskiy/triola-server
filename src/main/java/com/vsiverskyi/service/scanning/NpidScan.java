package com.vsiverskyi.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.model.Accountant;
import com.vsiverskyi.model.Unit;
import com.vsiverskyi.model.balance.Balance;
import com.vsiverskyi.model.groups.PlatVidomGroup;
import com.vsiverskyi.model.groups.UnitGroup;
import com.vsiverskyi.repository.AccountantRepo;
import com.vsiverskyi.repository.UnitRepo;
import com.vsiverskyi.repository.balance.BalanceRepo;
import com.vsiverskyi.repository.groups.NpidGruRepo;
import com.vsiverskyi.repository.groups.NplaGruRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

@Slf4j
@Service
@RequiredArgsConstructor
public class NpidScan {

    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader npidReader;
    private DBFReader npidGruReader;
    private DBFReader nplaGruReader;
    private DBFReader nbuhReader;
    private final NpidGruRepo npidGruRepo;
    private final UnitRepo unitRepo;
    private final BalanceRepo balanceRepo;
    private final NplaGruRepo nplaGruRepo;
    private final AccountantRepo nbuhRepo;

    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        npidReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "npid.DBF"), Charset.forName("windows-1251"));
        npidGruReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "npidgru.DBF"), Charset.forName("windows-1251"));
        nplaGruReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "nplagru.DBF"), Charset.forName("windows-1251"));
        nbuhReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "nbuh.DBF"), Charset.forName("windows-1251"));
    }

    public void scanUnits() throws ScanningWasNotCompletedException {
        scanAccountant();
        scanNplaGru();
        scanNpidGru();
        scanNpid();
    }

    private void scanNpid() {
        try {
            DBFRow row;
            while ((row = npidReader.nextRow()) != null) {

                String kpidGru = row.getString("KPIDGRU");
                UnitGroup unitGroup = null;
                if (!kpidGru.isEmpty()) {
                     unitGroup = npidGruRepo.findById(kpidGru)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Unit group doesn't exist."));
                }

                String kbal = row.getString("KBAL");
                Balance balance = null;
                if (!kbal.isEmpty()) {
                    balance = balanceRepo.findById(kbal)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Balance doesn't exist."));
                }

                String nplagru = row.getString("KPLAGRU");
                PlatVidomGroup platVidomGroup = null;
                if (!nplagru.isEmpty()) {
                    platVidomGroup = nplaGruRepo.findById(nplagru)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Npla group doesn't exist. "));
                }

                String kbuh = row.getString("KBUH");
                Accountant accountant = null;
                if (!kbuh.isEmpty()) {
                     accountant = nbuhRepo.findById(kbuh)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Accountant doesn't exist."));
                }

                Unit unit = Unit.builder()
                        .code(row.getString("KPID"))
                        .title(row.getString("NPID"))
                        .accountant(accountant)
                        .unitGroup(unitGroup)
                        .balance(balance)
                        .nplagroup(platVidomGroup)
                        .build();
                unitRepo.save(unit);

            }
            log.info("Npid was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(npidReader);
        }
    }

    private void scanNpidGru() {
        try {
            DBFRow row;
            while ((row = npidGruReader.nextRow()) != null) {
                UnitGroup unitGroup = UnitGroup.builder()
                        .code(row.getString("KPIDGRU"))
                        .title(row.getString("NPIDGRU"))
                        .kdpa(row.getString("KDPA"))
                        .nbuh2(row.getString("NBUH2"))
                        .nker2(row.getString("NKER2"))
                        .nvyk(row.getString("NVYK"))
                        .build();
                npidGruRepo.save(unitGroup);
            }
            log.info("Unit groups were successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(npidGruReader);
        }
    }

    private void scanNplaGru() {
        try {
            DBFRow row;
            while ((row = nplaGruReader.nextRow()) != null) {
                PlatVidomGroup nplaGroup = PlatVidomGroup.builder()
                        .code(row.getString("KPLAGRU"))
                        .title(row.getString("NPLAGRU"))
                        .build();
                nplaGruRepo.save(nplaGroup);
            }
            log.info("Npla groups were successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(nplaGruReader);
        }
    }

    private void scanAccountant() {
        try {
            DBFRow row;
            while ((row = nbuhReader.nextRow()) != null) {
                Accountant accountant = Accountant.builder()
                        .code(row.getString("KBUH"))
                        .name(row.getString("NBUH"))
                        .build();
                nbuhRepo.save(accountant);
            }
            log.info("Accountants were successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(nbuhReader);
        }
    }
}

