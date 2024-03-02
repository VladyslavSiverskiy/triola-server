package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Mdok}
 */
@Value
public class MdokDto implements Serializable {
    MdokKeyDto mdokKey;
    EmployeeDto employee;
    DocumentDto document;
    LocalDate endDate;
    String s;
    String kint;
    LocalDate archivationDate;
    String knomlik;
    LocalDate dnak;
    String knak;
}