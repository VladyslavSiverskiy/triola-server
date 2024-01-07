package com.vsiverskyi.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.model.Accountant;
import com.vsiverskyi.model.Document;
import com.vsiverskyi.model.Unit;
import com.vsiverskyi.model.balance.Balance;
import com.vsiverskyi.model.groups.DocumentGroup;
import com.vsiverskyi.model.groups.PlatVidomGroup;
import com.vsiverskyi.model.groups.UnitGroup;
import com.vsiverskyi.repository.DocumentRepo;
import com.vsiverskyi.repository.graphs.GraphNrobRepo;
import com.vsiverskyi.repository.graphs.GraphicRepo;
import com.vsiverskyi.repository.groups.NdokGroupRepo;
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
public class NdokScan {

    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader ndokReader;
    private DBFReader ndokgruReader;
    private final NdokGroupRepo ndokGroupRepo;
    private final DocumentRepo ndokRepo;


    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        ndokReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "ndok.DBF"),  Charset.forName("windows-1251"));
        ndokgruReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "ndokgru.DBF"),  Charset.forName("windows-1251"));
    }

    public void scanDocuments() {
        scanNdokGru();
        scanNdok();
    }

    private void scanNdok() {

        try {
            DBFRow row;
            while ((row = ndokReader.nextRow()) != null) {

                String ndokGru = row.getString("KDOKGRU");
                DocumentGroup documentGroup = null;
                if (!ndokGru.isEmpty()) {
                    documentGroup = ndokGroupRepo.findById(ndokGru)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Unit group doesn't exist."));
                }

                Document document = Document.builder()
                        .documentCode(row.getString("KDOK"))
                        .documentName(row.getString("NDOK"))
                        .documentNameMin(row.getString("NDOKMIN"))
                        .docGroup(documentGroup)
                        .ppod(row.getBoolean("PPOD"))
                        .ppro(row.getBoolean("PPRO"))
                        .ppen(row.getBoolean("PPEN"))
                        .pbez(row.getBoolean("PBEZ"))
                        .pmat(row.getBoolean("PMAT"))
                        .pali(row.getBoolean("PALI"))
                        .plik(row.getBoolean("PLIK"))
                        .pvid(row.getBoolean("PVID"))
                        .pzbipen(row.getBoolean("PZBIPEN"))
                        .pdohdov(row.getBoolean("PDOHDOV"))
                        .pdohdovdop(row.getBoolean("PDOHDOVDOP"))
                        .ppendov(row.getBoolean("PPENDOV"))
                        .qnad(row.getString("QNAD"))
                        .knadprs(row.getString("KNADPRS"))
                        .lnadprs(row.getString("LNADPRS"))
                        .kfnr(row.getString("KFNR"))
                        .krah(row.getString("KRAH"))
                        .kdok8dr(row.getString("KDOK8DR"))
                        .k1pv(row.getString("K1PV"))
                        .pvz(row.getBoolean("PVZ"))
                        .krahdt(row.getString("KRAHDT"))
                        .krahkt(row.getString("KRAHKT"))
                        .pbor(row.getString("PBOR"))
                        .kdokgrue(row.getString("KDOKGRUE"))
                        .qtoc(row.getString("QTOC"))
                        .kana(row.getString("KANA"))
                        .kpod8dr(row.getString("KPOD8DR"))
                        .prazlik(row.getBoolean("PRAZLIK"))
                        .grafa(row.getString("GRAFA"))
                        .qtar(row.getString("QTAR"))
                        .kfs6(row.getString("KFS6"))
                        .build();
                ndokRepo.save(document);

            }
            log.info("ndok was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(ndokReader);
        }


    }

    private void scanNdokGru() {
        try {
            DBFRow row;
            while ((row = ndokgruReader.nextRow()) != null) {
                DocumentGroup ndokGru = DocumentGroup.builder()
                        .groupCode(row.getString("KDOKGRU"))
                        .nVym(row.getString("NVYM"))
                        .groupName(row.getString("NDOKGRU"))
                        .ppod(row.getBoolean("PPOD"))
                        .ppro(row.getBoolean("PPRO"))
                        .ppen(row.getBoolean("PPEN"))
                        .pbez(row.getBoolean("PBEZ"))
                        .pali(row.getBoolean("PALI"))
                        .plik(row.getBoolean("PLIK"))
                        .pvid(row.getBoolean("PVID"))
                        .pzbipen(row.getBoolean("PZBIPEN"))
                        .pdohdov(row.getBoolean("PDOHDOV"))
                        .pzbisoc(row.getBoolean("PZBISOC"))
                        .pzbibez(row.getBoolean("PZBIBEZ"))
                        .pzbines(row.getBoolean("PZBINES"))
                        .ppendov(row.getBoolean("PPENDOV"))
                        .kdok8dr(row.getString("KDOK8DR"))
                        .k1pv(row.getString("K1PV"))
                        .pvz(row.getBoolean("PVZ"))
                        .build();
                ndokGroupRepo.save(ndokGru);
            }
            log.info("Document groups were successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(ndokgruReader);
        }
    }
}
