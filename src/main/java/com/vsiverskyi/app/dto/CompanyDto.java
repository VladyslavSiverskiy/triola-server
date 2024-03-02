package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.balance.Company}
 */
@Value
public class CompanyDto implements Serializable {
    Long id;
    String fullTitle;
    String shortTitle;
    String edrpou;
    String pfEdrpou;
    String address;
    String phone;
    String kpkKfk;
}