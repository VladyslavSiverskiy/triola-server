package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.groups.PlatVidomGroup}
 */
@Value
public class PlatVidomGroupDto implements Serializable {
    String code;
    String title;
}