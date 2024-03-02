package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.groups.BalanceGroup}
 */
@Value
public class BalanceGroupDto implements Serializable {
    String code;
    String title;
}