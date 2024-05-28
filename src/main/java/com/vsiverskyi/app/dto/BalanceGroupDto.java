package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.groups.BalanceGroup;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link BalanceGroup}
 */
@Value
public class BalanceGroupDto implements Serializable {
    String code;
    String title;
}