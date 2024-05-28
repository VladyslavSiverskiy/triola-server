package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.Mutr;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Mutr}
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