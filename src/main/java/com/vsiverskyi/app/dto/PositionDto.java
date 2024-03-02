package com.vsiverskyi.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.Position}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {
    private String kror;
    private LocalDate dbaz;
    private Double sokl;
    private Double qokl;
    private String code;
    private String title;
    private PositionGroupDto positionGroup;
    private String titleMax;
    private String codeKP;
    private String codeZKPTTR;
    private String namePRO;
    private Double qpre;
    private Double qpre22;
}