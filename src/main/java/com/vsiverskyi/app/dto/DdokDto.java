package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.Ddok;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Ddok}
 */
@Value
public class DdokDto implements Serializable {
    DdokKeyDto ddokKey;
    EmployeeDto employee;
    DocumentDto document;
    LocalDate endDate;
    String s;
    String pgot;
    UnitDto unitCode;
    String kint;
    CategoryDto categoryCode;
    String krah;
    LocalDate archivationDate;
    String kroz;
    String knomlik;
    Double tgod;
    Double tdni;
    String lerr;
    LocalDate dnak;
    String knak;
}