package com.vsiverskyi.model.groups;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NDOKGRU")
public class DocumentGroup {

    @Id
    @Column(name = "KDOKGRU")
    private String groupCode;

    @Column(name = "NVYM")
    private String nVym;

    @Column(name = "NDOKGRU")
    private String groupName;
    @Column
    private Boolean ppod;
    @Column private Boolean ppen;
    @Column
    private Boolean pbez;
    @Column
    private Boolean ppro;
    @Column
    private Boolean pali;
    @Column
    private Boolean plik;
    @Column
    private Boolean pvid;
    @Column
    private Boolean pzbipen;
    @Column
    private Boolean pzbisoc;
    @Column
    private Boolean pzbibez;
    @Column
    private Boolean pzbines;
    @Column
    private Boolean pdohdov;
    @Column
    private Boolean ppendov;
    @Column
    private String kdok8dr;
    @Column
    private String k1pv;
    @Column
    private Boolean pvz;
}
