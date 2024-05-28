package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.Accountant;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Accountant}
 */
@Value
public class AccountantDto implements Serializable {
    String code;
    String name;
}