package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.groups.CategoryGroup}
 */
@Value
public class CategoryGroupDto implements Serializable {
    String code;
    String title;
}