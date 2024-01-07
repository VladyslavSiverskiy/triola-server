package com.vsiverskyi.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.EmployeeRepo;
import com.vsiverskyi.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.model.*;
import com.vsiverskyi.repository.*;
import com.vsiverskyi.repository.balance.BalanceRepo;
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
public class MnarDnarScan {

    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader mnarReader;
    private DBFReader dnarReader;
    private final MnarRepo mnarRepo;
    private final DnarRepo dnarRepo;
    private final EmployeeRepo employeeRepo;
    private final BalanceRepo balanceRepo;
    private final DocumentRepo documentRepo;
    private final CategoryRepo categoryRepo;
    private final PositionRepo positionRepo;
    private final UnitRepo unitRepo;


    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        mnarReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "mnar.DBF"),
                Charset.forName("windows-1251"));
        dnarReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "dnar.DBF"),
                Charset.forName("windows-1251"));
    }

    public void scanMnarDnar() {
        scanMnar();
        scanDnar();
    }

    private void scanMnar() {
        try {
            DBFRow row;
            while ((row = mnarReader.nextRow()) != null) {
                String unitCode = row.getString("KPID");
                Unit unit = null;
                if (!unitCode.isEmpty()) {
                    unit = unitRepo.findById(unitCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Unit group doesn't exist."));
                }
                String employeeCode = row.getString("KTAB");
                Employee employee = null;
                if (!employeeCode.isEmpty()) {
                    employee = employeeRepo.findById(employeeCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Employee doesn't exist."));
                }

                String documentCode = row.getString("KDOK");
                Document document = null;
                if (!documentCode.isEmpty()) {
                    document = documentRepo.findById(documentCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Document doesn't exist."));
                }

                String categoryCode = row.getString("KKAT");
                Category category = null;
                if (!categoryCode.isEmpty()) {
                    category = categoryRepo.findById(categoryCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Category doesn't exist."));
                }

                String positionCode = row.getString("KPOS");
                Position position = null;
                if (!positionCode.isEmpty()) {
                    position = positionRepo.findById(positionCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Position doesn't exist."));
                }


                MnarKey mnarKey = MnarKey.builder()
                        .tabNumberCode(row.getString("KTAB"))
                        .documentCode(row.getString("KDOK"))
                        .build();
                Date dpoc = row.getDate("DPOC");
                if (dpoc != null) {
                    mnarKey.setStartDate(dpoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Mnar mnar = Mnar.builder()
                        .mnarKey(mnarKey)
                        .employee(employee)
                        .document(document)
                        .tdni(row.getDouble("TDNI"))
                        .tgod(row.getDouble("TGOD"))
                        .s(row.getString("S"))
                        .kkzo(row.getString("KKZO"))
                        .ktyp(row.getString("KTYP"))
                        .kpen(row.getString("KPEN"))
                        .tvid(row.getDouble("TVID"))
                        .pgot(row.getString("PGOT"))
                        .unitCode(unit)
                        .categoryCode(category)
                        .position(position)
                        .kper(row.getString("KPER"))
                        .krah(row.getString("KRAH"))
                        .kint(row.getString("KINT"))
                        .spen(row.getDouble("SPEN"))
                        .pinv(row.getBoolean("PINV"))
                        .snarpen(row.getDouble("SNARPEN"))
                        .kide(row.getString("KIDE"))
                        .p(row.getDouble("P"))
                        .knak(row.getString("KNAK"))
                        .build();
                Date darc = row.getDate("DARC");
                if (darc != null) {
                    mnar.setArchivationDate(darc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dsoc = row.getDate("DSOC");
                if (darc != null) {
                    mnar.setSocDate(dsoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dpod = row.getDate("DPOD");
                if (dpod != null) {
                    mnar.setPodDate(dpod.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dnak = row.getDate("DNAK");
                if (dnak != null) {
                    mnar.setDnak(dnak.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                mnarRepo.save(mnar);
            }
            log.info("Mnar was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(mnarReader);
        }
    }

    private void scanDnar() {
        try {
            DBFRow row;
            while ((row = dnarReader.nextRow()) != null) {
                String unitCode = row.getString("KPID");
                Unit unit = null;
                if (!unitCode.isEmpty()) {
                    unit = unitRepo.findById(unitCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Unit group doesn't exist."));
                }
                String employeeCode = row.getString("KTAB");
                Employee employee = null;
                if (!employeeCode.isEmpty()) {
                    employee = employeeRepo.findById(employeeCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Employee doesn't exist."));
                }

                String documentCode = row.getString("KDOK");
                Document document = null;
                if (!documentCode.isEmpty()) {
                    document = documentRepo.findById(documentCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Document doesn't exist."));
                }

                String categoryCode = row.getString("KKAT");
                Category category = null;
                if (!categoryCode.isEmpty()) {
                    category = categoryRepo.findById(categoryCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Category doesn't exist."));
                }

                String positionCode = row.getString("KPOS");
                Position position = null;
                if (!positionCode.isEmpty()) {
                    position = positionRepo.findById(positionCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Position doesn't exist."));
                }
                DnarKey dnarKey = DnarKey.builder()
                        .tabNumberCode(row.getString("KTAB"))
                        .documentCode(row.getString("KDOK"))
                        .build();
                Date dpoc = row.getDate("DPOC");
                if (dpoc != null) {
                    dnarKey.setStartDate(dpoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Dnar dnar = Dnar.builder()
                        .dnarKey(dnarKey)
                        .employee(employee)
                        .document(document)
                        .s(row.getString("S"))
                        .kkzo(row.getString("KKZO"))
                        .ktyp(row.getString("KTYP"))
                        .kper(row.getString("KPER"))
                        .sold(row.getString("PGOT"))
                        .unitCode(unit)
                        .categoryCode(category)
                        .position(position)
                        .kper(row.getString("KPER"))
                        .krah(row.getString("KRAH"))
                        .kint(row.getString("KINT"))
                        .spen(row.getDouble("SPEN"))
                        .pinv(row.getBoolean("PINV"))
                        .snarpen(row.getDouble("SNARPEN"))
                        .kide(row.getString("KIDE"))
                        .p(row.getDouble("P"))
                        .knak(row.getString("KNAK"))
                        .tdni(row.getDouble("TDNI"))
                        .tdniold(row.getDouble("TDNIOLD"))
                        .tviold(row.getDouble("TVIDOLD"))
                        .tgod(row.getDouble("TGOD"))
                        .tgodold(row.getDouble("TGODOLD"))
                        .build();

                Date darc = row.getDate("DARC");
                if (darc != null) {
                    dnar.setArchivationDate(darc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dsoc = row.getDate("DSOC");
                if (darc != null) {
                    dnar.setSocDate(dsoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dpod = row.getDate("DPOD");
                if (dpod != null) {
                    dnar.setPodDate(dpod.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dnak = row.getDate("DNAK");
                if (dnak != null) {
                    dnar.setDnak(dnak.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                dnarRepo.save(dnar);
            }
            log.info("Dnar was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(dnarReader);
        }
    }
}
