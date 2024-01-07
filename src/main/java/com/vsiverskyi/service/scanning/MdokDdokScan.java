package com.vsiverskyi.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.EmployeeRepo;
import com.vsiverskyi.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.model.*;
import com.vsiverskyi.repository.*;
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
public class MdokDdokScan {
    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader mdokReader;
    private DBFReader ddokReader;
    private final CategoryRepo categoryRepo;
    private final UnitRepo unitRepo;
    private final MdokRepo mdokRepo;
    private final DdokRepo ddokRepo;
    private final EmployeeRepo employeeRepo;
    private final DocumentRepo documentRepo;

    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        mdokReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "mdok.DBF"),
                Charset.forName("windows-1251"));
        ddokReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "ddok.DBF"),
                Charset.forName("windows-1251"));
    }

    public void scanMdokDdok() {
        scanMdok();
        scanDdok();
    }

    private void scanMdok() {
        try {
            DBFRow row;
            while ((row = mdokReader.nextRow()) != null) {
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

                MdokKey mdokKey = MdokKey.builder()
                        .tabNumberCode(row.getString("KTAB"))
                        .documentCode(row.getString("KDOK"))
                        .build();
                Date dpoc = row.getDate("DPOC");
                if (dpoc != null) {
                    mdokKey.setStartDate(dpoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }

                Mdok mdok = Mdok.builder()
                        .mdokKey(mdokKey)
                        .employee(employee)
                        .document(document)
                        .s(row.getString("S"))
                        .kint(row.getString("KINT"))
                        .knak(row.getString("KNAK"))
                        .knomlik(row.getString("KNOMLIK"))
                        .build();

                Date darc = row.getDate("DARC");
                if (darc != null) {
                    mdok.setArchivationDate(darc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }

                Date dkin = row.getDate("DKIN");
                if (dkin != null) {
                    mdok.setEndDate(dkin.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dnak = row.getDate("DNAK");
                if (dnak != null) {
                    mdok.setDnak(dnak.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                mdokRepo.save(mdok);
            }
            log.info("Mdok was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(mdokReader);
        }
    }

    private void scanDdok() {
        try {
            DBFRow row;
            while ((row = ddokReader.nextRow()) != null) {
                String unitCode = row.getString("KPID");
                Unit unit = null;
                if (!unitCode.isEmpty()) {
                    unit = unitRepo.findById(unitCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Unit group doesn't exist."));
                }
                String categoryCode = row.getString("KKAT");
                Category category = null;
                if (!categoryCode.isEmpty()) {
                    category = categoryRepo.findById(categoryCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Category doesn't exist."));
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

                MdokKey mdokKey = MdokKey.builder()
                        .tabNumberCode(row.getString("KTAB"))
                        .documentCode(row.getString("KDOK"))
                        .build();
                Date dpoc = row.getDate("DPOC");
                if (dpoc != null) {
                    mdokKey.setStartDate(dpoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }

                Ddok ddok = Ddok.builder()
                        .mdokKey(mdokKey)
                        .employee(employee)
                        .document(document)
                        .categoryCode(category)
                        .unitCode(unit)
                        .s(row.getString("S"))
                        .kint(row.getString("KINT"))
                        .knak(row.getString("KNAK"))
                        .knomlik(row.getString("KNOMLIK"))
                        .kroz(row.getString("KROZ"))
                        .krah(row.getString("KRAH"))
                        .lerr(row.getString("LERR"))
                        .pgot(row.getString("PGOT"))
                        .tdni(row.getDouble("TDNI"))
                        .tgod(row.getDouble("TGOD"))
                        .build();

                Date darc = row.getDate("DARC");
                if (darc != null) {
                    ddok.setArchivationDate(darc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }

                Date dkin = row.getDate("DKIN");
                if (dkin != null) {
                    ddok.setEndDate(dkin.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Date dnak = row.getDate("DNAK");
                if (dnak != null) {
                    ddok.setDnak(dnak.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                ddokRepo.save(ddok);
            }
            log.info("Ddok was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(ddokReader);
        }
    }
}
