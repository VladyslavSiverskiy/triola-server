package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.balance.Balance}
 */
@Value
public class BalanceDto implements Serializable {
    String code;
    BalanceGroupDto balanceGroup;
    String title;
    CompanyDto company;
    BankDto bank;
    ManagerDto manager;
    String accountantNameAndSurname;
    String accountantIdCode;
    String accountantPhone;
    String accountantPosition;
    String regionCode;
    String codeDpi;
    String edrpou;
    String dpiName;
    String registerNumber;
    String registerNumber2;
    String fondName;
    String voManagerName;
    String bankRR;
    String mfoSoc;
    Boolean voSoc;
    Long orderCount;
    Boolean doNotTransferToBank;
    String nmo5;
}