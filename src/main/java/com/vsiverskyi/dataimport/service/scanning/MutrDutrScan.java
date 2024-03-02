package com.vsiverskyi.dataimport.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.dataimport.model.*;
import com.vsiverskyi.dataimport.repository.DocumentRepo;
import com.vsiverskyi.dataimport.repository.DutrRepo;
import com.vsiverskyi.dataimport.repository.MutrRepo;
import com.vsiverskyi.dataimport.repository.UnitRepo;
import com.vsiverskyi.dataimport.exception.scanning.ScanningWasNotCompletedException;
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
public class MutrDutrScan {

    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader mutrReader;
    private DBFReader dutrReader;
    private final MutrRepo mutrRepo;
    private final DutrRepo dutrRepo;
    private final UnitRepo unitRepo;
    private final DocumentRepo documentRepo;

    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        mutrReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "mutr.DBF"),  Charset.forName("windows-1251"));
        dutrReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "dutr.DBF"),  Charset.forName("windows-1251"));
    }

    public void scanMutrDutr() {
        scanMutr();
        scanDutr();
    }

    private void scanMutr() {
        try {
            DBFRow row;
            while ((row = mutrReader.nextRow()) != null) {
                String unitCode = row.getString("KPID");
                Unit unit = null;
                if (!unitCode.isEmpty()) {
                    unit = unitRepo.findById(unitCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Unit doesn't exist."));
                }
                MutrKey mutrKey = MutrKey.builder()
                        .tabNumberCode(row.getString("KTAB"))
                        .documentCode(row.getString("KDOK"))
                        .build();
                Date dpoc = row.getDate("DPOC");
                if (dpoc != null) {
                    mutrKey.setStartDate(dpoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Mutr mutr = Mutr.builder()
                        .mutrKey(mutrKey)
                        .pgot(row.getString("PGOT"))
                        .unitCode(unit)
                        .kdil(row.getString("KDIL"))
                        .s(Double.valueOf(row.getString("S")))
                        .qpen(row.getString("QPEN"))
                        .kroz(row.getString("KROZ"))
                        .build();
                Date darc = row.getDate("DARC");
                if (darc != null) {
                    mutr.setArchivationDate(darc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                mutrRepo.save(mutr);
            }
            log.info("Mutr was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(mutrReader);
        }

    }

    private void scanDutr() {
        try {
            DBFRow row;
            while ((row = dutrReader.nextRow()) != null) {
                String unitCode = row.getString("KPID");
                Unit unit = null;
                if (!unitCode.isEmpty()) {
                    unit = unitRepo.findById(unitCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Unit group doesn't exist."));
                }

                String documentCode = row.getString("KDOK");
                Document document = null;
                if (!documentCode.isEmpty()) {
                    document = documentRepo.findById(documentCode)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Document doesn't exist."));
                }


                DutrKey dutrKey = DutrKey.builder()
                        .tabNumberCode(row.getString("KTAB"))
                        .documentCode(row.getString("KDOK"))
                        .build();
                Date dpoc = row.getDate("DPOC");
                if (dpoc != null) {
                    dutrKey.setStartDate(dpoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                Dutr dutr = Dutr.builder()
                        .dutrKey(dutrKey)
                        .document(document)
                        .pgot(row.getString("PGOT"))
                        .unitCode(unit)
                        .kdil(row.getString("KDIL"))
                        .s(Double.valueOf(row.getString("S")))
                        .kide(row.getString("KIDE"))
                        .kroz(row.getString("KROZ"))
                        .build();
                Date darc = row.getDate("DARC");
                if (darc != null) {
                    dutr.setArchivationDate(darc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                dutrRepo.save(dutr);
            }
            log.info("Dutr was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(dutrReader);
        }

    }

}
