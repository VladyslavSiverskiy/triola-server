package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.groups.CategoryGroup;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link CategoryGroup}
 */
@Value
public class CategoryGroupDto implements Serializable {
    String code;
    String title;
}