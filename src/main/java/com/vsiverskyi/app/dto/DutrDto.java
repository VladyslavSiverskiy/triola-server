package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.Dutr;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Dutr}
 */
@Value
public class DutrDto implements Serializable {
    DutrKeyDto dutrKey;
    EmployeeDto employee;
    DocumentDto document;
    LocalDate socDate;
    Double s;
    String pgot;
    LocalDate archivationDate;
    String kroz;
    UnitDto unitCode;
    String kdil;
    String kide;
}