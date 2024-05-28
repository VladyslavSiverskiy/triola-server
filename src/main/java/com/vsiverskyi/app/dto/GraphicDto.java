package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.graphs.Graphic;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Graphic}
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