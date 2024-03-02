package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Dnar}
 */
@Value
public class DnarDto implements Serializable {
    DnarKeyDto dnarKey;
    EmployeeDto employee;
    DocumentDto document;
    LocalDate socDate;
    LocalDate podDate;
    Double tdni;
    Double tgod;
    String s;
    Double p;
    String kide;
    String kkzo;
    String ktyp;
    UnitDto unitCode;
    CategoryDto categoryCode;
    PositionDto position;
    String kper;
    String krah;
    String kint;
    Double snarpen;
    LocalDate dnak;
    String knak;
    LocalDate archivationDate;
    Double tdniold;
    Double tgodold;
    String sold;
    Double tviold;
    Double spen;
    Boolean pinv;
}