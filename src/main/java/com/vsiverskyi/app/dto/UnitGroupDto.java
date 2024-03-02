package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.groups.UnitGroup}
 */
@Value
public class UnitGroupDto implements Serializable {
    String code;
    String title;
    String kdpa;
    String nker2;
    String nbuh2;
    String nvyk;
}