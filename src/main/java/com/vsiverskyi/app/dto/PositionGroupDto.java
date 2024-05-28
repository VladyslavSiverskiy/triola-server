package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.groups.PositionGroup;
import lombok.*;

/**
 * DTO for {@link PositionGroup}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PositionGroupDto{
    String code;
    String title;
}