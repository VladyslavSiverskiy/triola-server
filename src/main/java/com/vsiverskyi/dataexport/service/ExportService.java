package com.vsiverskyi.dataexport.service;

import com.linuxense.javadbf.*;
import com.vsiverskyi.dataimport.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.dataimport.model.Position;
import com.vsiverskyi.dataimport.model.groups.PositionGroup;
import com.vsiverskyi.dataimport.repository.PositionRepo;
import com.vsiverskyi.dataimport.repository.groups.PositionGroupRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExportService {

    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader nposReader;
    private DBFReader nposGruReader;
    private final PositionGroupRepo positionGroupRepo;
    private final PositionRepo positionRepo;

    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
    }

    public void exportData() throws FileNotFoundException {
        // let us create field definitions first
        // we will go for 3 fields
        nposReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "npos.DBF"),  Charset.forName("windows-1251"));
        nposGruReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "nposgru.DBF"),  Charset.forName("windows-1251"));

        DBFField[] fields = new DBFField[13];
        fields[0] = new DBFField();
        fields[0].setName("KROR");
        fields[0].setType(DBFDataType.CHARACTER);
        fields[0].setLength(2);
        fields[1] = new DBFField();
        fields[1].setName("DBAZ");
        fields[1].setType(DBFDataType.DATE);
        fields[1].setLength(8);
        fields[2] = new DBFField();
        fields[2].setName("NPOS");
        fields[2].setType(DBFDataType.CHARACTER);
        fields[2].setLength(70);
        fields[3] = new DBFField();
        fields[3].setName("KPOS");
        fields[3].setType(DBFDataType.CHARACTER);
        fields[3].setLength(5);
        fields[4] = new DBFField();
        fields[4].setName("KPOSGRU");
        fields[4].setType(DBFDataType.CHARACTER);
        fields[4].setLength(5);
        fields[5] = new DBFField();
        fields[5].setName("SOKL");
        fields[5].setType(DBFDataType.NUMERIC);
        fields[5].setLength(10);
        fields[5].setDecimalCount(2);
        fields[6] = new DBFField();
        fields[6].setName("QOKL");
        fields[6].setType(DBFDataType.NUMERIC);
        fields[6].setLength(5);
        fields[6].setDecimalCount(2);
        fields[7] = new DBFField();
        fields[7].setName("NPOSMAX");
        fields[7].setType(DBFDataType.CHARACTER);
        fields[7].setLength(100);
        fields[8] = new DBFField();
        fields[8].setName("KPRO");
        fields[8].setType(DBFDataType.CHARACTER);
        fields[8].setLength(7);
        fields[9] = new DBFField();
        fields[9].setName("KKZPP");
        fields[9].setType(DBFDataType.CHARACTER);
        fields[9].setLength(7);
        fields[10] = new DBFField();
        fields[10].setName("NPRO");
        fields[10].setType(DBFDataType.CHARACTER);
        fields[10].setLength(250);
        fields[11] = new DBFField();
        fields[11].setName("QPRE");
        fields[11].setType(DBFDataType.NUMERIC);
        fields[11].setLength(5);
        fields[11].setDecimalCount(2);
        fields[12] = new DBFField();
        fields[12].setName("QPRE22");
        fields[12].setType(DBFDataType.NUMERIC);
        fields[12].setLength(5);
        fields[12].setDecimalCount(2);

        DBFWriter writer = new DBFWriter(new FileOutputStream(dbfRoot + File.separator + "table.dbf"), Charset.forName("windows-1251"));
        writer.setFields(fields);
        Object rowData[];

        // now populate DBFWriter
        for (Position p: positionRepo.findAll()) {

            PositionGroup positionGroup = p.getPositionGroup();
            String positionGroupCode;
            if (positionGroup == null) {
                positionGroupCode = "";
            }else {
                positionGroupCode = positionGroup.getCode();
            }

            rowData = new Object[13];
            rowData[0] = p.getKror();
            rowData[1] = p.getDbaz();
            rowData[2] = p.getTitle();
            rowData[3] = p.getCode();
            rowData[4] = positionGroupCode;
            rowData[5] = p.getSokl();
            rowData[6] = p.getQokl();
            rowData[7] = p.getTitleMax();
            rowData[8] = p.getCodeKP();
            rowData[9] = p.getCodeZKPTTR();
            rowData[10] = p.getNamePRO();
            rowData[11] = p.getQpre();
            rowData[12] = p.getQpre22();
            writer.addRecord(rowData);
        }
        // write to file
        writer.close();
    }
}
