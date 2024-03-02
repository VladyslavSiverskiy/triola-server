package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Accountant}
 */
@Value
public class AccountantDto implements Serializable {
    String code;
    String name;
}