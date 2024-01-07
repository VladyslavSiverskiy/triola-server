package com.vsiverskyi.service.scanning;


import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.model.Position;
import com.vsiverskyi.model.graphs.GraphNROB;
import com.vsiverskyi.model.graphs.Graphic;
import com.vsiverskyi.model.groups.PositionGroup;
import com.vsiverskyi.repository.PositionRepo;
import com.vsiverskyi.repository.graphs.GraphNrobRepo;
import com.vsiverskyi.repository.graphs.GraphicRepo;
import com.vsiverskyi.repository.groups.PositionGroupRepo;
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
public class NrobNgraScan {

    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader ngraReader;
    private DBFReader nrobReader;
    private final GraphicRepo graphicRepo;
    private final GraphNrobRepo graphNrobRepo;



    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        ngraReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "ngra.DBF"),  Charset.forName("windows-1251"));
        nrobReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "nrob.DBF"),  Charset.forName("windows-1251"));
    }

    public void scanGraphs() {
        scanNrob();
        scanNgra();
    }

    private void scanNrob() {
        try {
            DBFRow row;
            while ((row = nrobReader.nextRow()) != null) {
                GraphNROB nrob = GraphNROB.builder()
                        .tgod01(row.getDouble("TGOD01"))
                        .tgod02(row.getDouble("TGOD02"))
                        .tgod03(row.getDouble("TGOD03"))
                        .tgod04(row.getDouble("TGOD04"))
                        .build();
                Date dpoc = row.getDate("DPOC");
                if (dpoc != null) {
                    nrob.setDpoc(dpoc.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                graphNrobRepo.save(nrob);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(nrobReader);
        }
        log.info("Nrob was successfully imported");
    }

    private void scanNgra() {
        try {
            DBFRow row;
            while ((row = ngraReader.nextRow()) != null) {
                Graphic ngra = Graphic.builder()
                        .code(row.getString("KGRA"))
                        .title(row.getString("NGRA"))
                        .edited((row.getBoolean("PGRARED")))
                        .daysCount(row.getInt("KILROBDNI"))
                        .hoursCount(row.getInt("KILROBGOD"))
                        .graphTemplate(row.getString("GRATEMPL"))
                        .build();
                graphicRepo.save(ngra);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(ngraReader);
        }
        log.info("Ngra was successfully imported");
    }
}
