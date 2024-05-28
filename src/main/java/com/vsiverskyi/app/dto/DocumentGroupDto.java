package com.vsiverskyi.app.dto;

import com.vsiverskyi.app.model.groups.DocumentGroup;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link DocumentGroup}
 */
@Value
public class DocumentGroupDto implements Serializable {
    String groupCode;
    String nVym;
    String groupName;
    Boolean ppod;
    Boolean ppen;
    Boolean pbez;
    Boolean ppro;
    Boolean pali;
    Boolean plik;
    Boolean pvid;
    Boolean pzbipen;
    Boolean pzbisoc;
    Boolean pzbibez;
    Boolean pzbines;
    Boolean pdohdov;
    Boolean ppendov;
    String kdok8dr;
    String k1pv;
    Boolean pvz;
}