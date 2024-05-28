package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.Employee;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Employee}
 */
@Value
public class EmployeeDto implements Serializable {
    String gender;
    UnitDto unitCode;
    String tabNumber;
    String name;
    String kide;
    LocalDate dataPryuniatia;
    LocalDate dataZvilnenia;
    LocalDate drozzvi;
    String kpod;
    Short kava;
    String nameMin;
    CategoryDto category;
    PositionDto positionCode;
    Short kper;
    String krah;
    String qsta;
    String sokl;
    String kkla;
    String kror;
    LocalDate dbaz;
    String kdpa;
    Boolean pdruk;
    LocalDate drestruct;
}