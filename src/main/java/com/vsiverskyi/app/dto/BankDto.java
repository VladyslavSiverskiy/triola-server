package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.balance.Bank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Bank}
 */
@Value
public class BankDto implements Serializable {
    Long id;
    String title;
    String krozrah;
    String mfo;
}