package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.balance.Manager;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Manager}
 */
@Value
public class ManagerDto implements Serializable {
    Long id;
    String nameAndSurname;
    String idCode;
    String phone;
    String position;
}