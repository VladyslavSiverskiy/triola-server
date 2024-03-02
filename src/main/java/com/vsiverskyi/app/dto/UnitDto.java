package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Unit}
 */
@Value
public class UnitDto implements Serializable {
    String code;
    String title;
    BalanceDto balance;
    UnitGroupDto unitGroup;
    AccountantDto accountant;
    PlatVidomGroupDto nplagroup;
    String lgrokas;
    String kkas;
    String ktab;
    String kide;
    String kdpa;
    Double qroz;
    Boolean lfolder;
    Boolean kpidup;
}