package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.groups.UnitGroup;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link UnitGroup}
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