package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.balance.Company;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Company}
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