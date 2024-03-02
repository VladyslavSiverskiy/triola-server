package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Mnar}
 */
@Value
public class MnarDto implements Serializable {
    MnarKeyDto mnarKey;
    EmployeeDto employee;
    DocumentDto document;
    LocalDate socDate;
    LocalDate podDate;
    Double tdni;
    Double tgod;
    String s;
    String kkzo;
    String ktyp;
    String kpen;
    Double tvid;
    String pgot;
    UnitDto unitCode;
    CategoryDto categoryCode;
    PositionDto position;
    String kper;
    String krah;
    String kint;
    Double spen;
    Boolean pinv;
    Double snarpen;
    String kide;
    Double p;
    LocalDate dnak;
    String knak;
    LocalDate archivationDate;
}