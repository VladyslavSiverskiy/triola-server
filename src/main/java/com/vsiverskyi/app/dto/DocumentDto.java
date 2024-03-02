package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Document}
 */
@Value
public class DocumentDto implements Serializable {
    String documentCode;
    String documentNameMin;
    String documentName;
    DocumentGroupDto docGroup;
    Boolean ppod;
    Boolean ppen;
    Boolean ppro;
    Boolean pbez;
    Boolean pmat;
    Boolean pali;
    Boolean plik;
    Boolean pvid;
    Boolean pzbipen;
    Boolean pdohdov;
    Boolean pdohdovdop;
    Boolean ppendov;
    String qnad;
    String knadprs;
    String lnadprs;
    String kfnr;
    String krah;
    String kdok8dr;
    String k1pv;
    String krahdt;
    String krahkt;
    String pbor;
    String kdokgrue;
    String qtoc;
    String kana;
    String kpod8dr;
    Boolean prazlik;
    String grafa;
    Boolean pvz;
    String qtar;
    String kfs6;
}