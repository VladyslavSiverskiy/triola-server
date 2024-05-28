package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.DnarKey;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link DnarKey}
 */
@Value
public class DnarKeyDto implements Serializable {
    String tabNumberCode;
    String documentCode;
    LocalDate startDate;
}