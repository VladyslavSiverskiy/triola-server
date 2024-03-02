package com.vsiverskyi.app.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsiverskyi.dataimport.model.graphs.Graphic}
 */
@Value
public class GraphicDto implements Serializable {
    String code;
    String title;
    Boolean edited;
    Integer daysCount;
    Integer hoursCount;
    String graphTemplate;
}