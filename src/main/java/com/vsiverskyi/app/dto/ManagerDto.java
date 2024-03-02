package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.balance.Manager}
 */
@Value
public class ManagerDto implements Serializable {
    Long id;
    String nameAndSurname;
    String idCode;
    String phone;
    String position;
}