package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.MdokKey}
 */
@Value
public class MdokKeyDto implements Serializable {
    String tabNumberCode;
    String documentCode;
    LocalDate startDate;
}