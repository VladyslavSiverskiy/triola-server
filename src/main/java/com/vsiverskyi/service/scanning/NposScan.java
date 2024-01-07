package com.vsiverskyi.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.model.Position;
import com.vsiverskyi.model.groups.PositionGroup;
import com.vsiverskyi.repository.PositionRepo;
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
public class NposScan {

    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader nposReader;
    private DBFReader nposGruReader;
    private final PositionGroupRepo positionGroupRepo;
    private final PositionRepo positionRepo;



    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        nposReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "npos.DBF"),  Charset.forName("windows-1251"));
        nposGruReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "nposgru.DBF"),  Charset.forName("windows-1251"));
    }

    public void scanPositions() {
        scanNposGru();
        scanNpos();
    }

    private void scanNpos() {
        try {
            DBFRow row;
            while ((row = nposReader.nextRow()) != null) {
                String kposGru = row.getString("KPOSGRU");
                PositionGroup positionGroup = null;
                if (!kposGru.isEmpty()) {
                    positionGroup = positionGroupRepo.findById(kposGru)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Position group doesn't exist."));
                }

                Position position = Position.builder()
                        .kror(row.getString("KROR"))
                        .sokl(row.getDouble("SOKL"))
                        .qokl(row.getDouble("QOKL"))
                        .code(row.getString("KPOS"))
                        .title(row.getString("NPOS"))
                        .qpre(row.getDouble("QPRE"))
                        .qpre22(row.getDouble("QPRE22"))
                        .codeKP(row.getString("KPRO"))
                        .namePRO(row.getString("NPRO"))
                        .positionGroup(positionGroup)
                        .titleMax(row.getString("NPOSMAX"))
                        .codeZKPTTR(row.getString("KKZPP"))
                        .build();
                Date dbaz = row.getDate("DBAZ");
                if (dbaz != null) {
                    position.setDbaz(dbaz.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                positionRepo.save(position);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.getStackTrace();
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(nposReader);
        }
        log.info("Npos was successfully imported");
    }

    private void scanNposGru(){
        try {
            DBFRow row;
            while ((row = nposGruReader.nextRow()) != null) {
                PositionGroup positionGroup = PositionGroup.builder()
                        .code(row.getString("KPOSGRU"))
                        .title(row.getString("NPOSGRU"))
                        .build();
                positionGroupRepo.save(positionGroup);

            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(nposGruReader);
        }
        log.info("Position groups were successfully imported");
    }
}
