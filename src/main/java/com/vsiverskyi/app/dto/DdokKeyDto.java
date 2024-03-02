package com.vsiverskyi.app.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class DdokKeyDto {
    String tabNumberCode;
    String documentCode;
    LocalDate startDate;
}
