package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.MutrKey;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link MutrKey}
 */
@Value
public class MutrKeyDto implements Serializable {
    String tabNumberCode;
    String documentCode;
    LocalDate startDate;
}