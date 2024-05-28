package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.DutrKey;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link DutrKey}
 */
@Value
public class DutrKeyDto implements Serializable {
    String tabNumberCode;
    String documentCode;
    LocalDate startDate;
}