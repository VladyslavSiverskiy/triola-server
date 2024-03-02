package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.graphs.GraphNROB}
 */
@Value
public class GraphNROBDto implements Serializable {
    LocalDate dpoc;
    Double tgod01;
    Double tgod02;
    Double tgod03;
    Double tgod04;
}