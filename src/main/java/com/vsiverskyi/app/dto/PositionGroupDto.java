package com.vsiverskyi.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.groups.PositionGroup}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionGroupDto{
    String code;
    String title;
}