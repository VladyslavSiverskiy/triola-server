package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.balance.Bank}
 */
@Value
public class BankDto implements Serializable {
    Long id;
    String title;
    String krozrah;
    String mfo;
}