package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Mutr}
 */
@Value
public class MutrDto implements Serializable {
    MutrKeyDto mutrKey;
    Double s;
    String pgot;
    UnitDto unitCode;
    String kdil;
    LocalDate archivationDate;
    String kroz;
    String qpen;
}