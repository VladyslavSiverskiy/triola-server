package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.graphs.GraphNROB;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link GraphNROB}
 */
@Value
public class GraphNROBDto implements Serializable {
    LocalDate dpoc;
    Double tgod01;
    Double tgod02;
    Double tgod03;
    Double tgod04;
}