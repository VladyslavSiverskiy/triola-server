package com.vsiverskyi.dataimport.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.dataimport.model.Category;
import com.vsiverskyi.dataimport.model.Employee;
import com.vsiverskyi.dataimport.model.Position;
import com.vsiverskyi.dataimport.model.Unit;
import com.vsiverskyi.dataimport.repository.CategoryRepo;
import com.vsiverskyi.dataimport.repository.NtabRepo;
import com.vsiverskyi.dataimport.repository.UnitRepo;
import com.vsiverskyi.dataimport.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.dataimport.repository.PositionRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class NtabScan {

    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader ntabReader;
    private final CategoryRepo categoryRepo;
    private final NtabRepo ntabRepo;
    private final UnitRepo unitRepo;
    private final PositionRepo positionRepo;

    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        ntabReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "ntab.DBF"), Charset.forName("windows-1251"));
    }

    public void scanNtab() {
        try {
            DBFRow row;
            while ((row = ntabReader.nextRow()) != null) {
                String kpid = row.getString("KPID");
                Unit unit = null;
                if (!kpid.isEmpty()) {
                    unit = unitRepo.findById(kpid)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Unit doesn't exist."));
                }
                String kkat = row.getString("KKAT");
                Category category = null;
                if (!kkat.isEmpty()) {
                    category = categoryRepo.findById(kkat)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Category doesn't exist."));
                }
                String kpos = row.getString("KPOS");
                Position position = null;
                if (!kpos.isEmpty()) {
                    position = positionRepo.findById(kpos)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Position doesn't exist."));
                }
                Employee employee = Employee.builder()
                        .gender(row.getString("KKAT"))
                        .unitCode(unit)
                        .tabNumber(row.getString("KTAB"))
                        .name(row.getString("NTAB"))
                        .kide(row.getString("KIDE"))
                        .category(category)
                        .kpod(row.getString("KPOD"))
                        .kava(Short.valueOf(row.getString("KAVA")))
                        .nameMin(row.getString("NTABMIN"))
                        .positionCode(position)
                        .krah(row.getString("KRAH"))
                        .qsta(row.getString("QSTA"))
                        .sokl(row.getString("SOKL"))
                        .kkla(row.getString("KKLA"))
                        .kror(row.getString("KROR"))
                        .kdpa(row.getString("KDPA"))
                        .pdruk(row.getBoolean("PDRUK"))
                        .build();
                Date dpry = row.getDate("DPRY");
                if (dpry != null) {
                    employee.setDataPryuniatia(dpry.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dzvi = row.getDate("DZVI");
                if (dzvi != null) {
                    employee.setDataZvilnenia(dzvi.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date drozzvi = row.getDate("DROZZVI");
                if (drozzvi != null) {
                    employee.setDrozzvi(drozzvi.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dbaz = row.getDate("DBAZ");
                if (dbaz != null) {
                    employee.setDbaz(dbaz.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date drestruct = row.getDate("DRESTRUCT");
                if (drestruct != null) {
                    employee.setDrestruct(drestruct.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                ntabRepo.save(employee);
            }
            log.info("Ntab was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(ntabReader);
        }
    }
}
