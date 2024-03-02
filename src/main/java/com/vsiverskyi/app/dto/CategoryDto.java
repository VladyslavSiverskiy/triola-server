package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Category}
 */
@Value
public class CategoryDto implements Serializable {
    String code;
    String title;
    CategoryGroupDto categoryGroup;
    BigDecimal oklSum;
    String nkatmax;
    String kkatokl;
}