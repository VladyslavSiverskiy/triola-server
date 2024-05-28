package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.MdokKey;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link MdokKey}
 */
@Value
public class MdokKeyDto implements Serializable {
    String tabNumberCode;
    String documentCode;
    LocalDate startDate;
}