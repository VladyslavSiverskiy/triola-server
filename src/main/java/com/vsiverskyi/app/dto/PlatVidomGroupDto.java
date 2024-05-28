package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.groups.PlatVidomGroup;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link PlatVidomGroup}
 */
@Value
public class PlatVidomGroupDto implements Serializable {
    String code;
    String title;
}