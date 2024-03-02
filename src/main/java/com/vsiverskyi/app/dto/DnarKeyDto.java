package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.DnarKey}
 */
@Value
public class DnarKeyDto implements Serializable {
    String tabNumberCode;
    String documentCode;
    LocalDate startDate;
}