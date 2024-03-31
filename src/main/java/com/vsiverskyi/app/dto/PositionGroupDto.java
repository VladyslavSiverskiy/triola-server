package com.vsiverskyi.app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.groups.PositionGroup}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PositionGroupDto{
    String code;
    String title;
}