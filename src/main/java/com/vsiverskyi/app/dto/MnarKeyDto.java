package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.MnarKey;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link MnarKey}
 */
@Value
public class MnarKeyDto implements Serializable {
    String tabNumberCode;
    String documentCode;
    LocalDate startDate;
}