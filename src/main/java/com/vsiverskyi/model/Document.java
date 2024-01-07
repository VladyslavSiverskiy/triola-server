package com.vsiverskyi.model;

import com.vsiverskyi.model.groups.DocumentGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

//Довідник документів
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NDOK")
public class Document {

    @Id
    @Column(name = "KDOK")
    private String documentCode;

    @Column(name = "NDOKMIN")
    private String documentNameMin;

    @Column(name = "NDOK")
    private String documentName;

    @ManyToOne
    @JoinColumn(name = "KDOKGRU", referencedColumnName = "KDOKGRU")
    private DocumentGroup docGroup;
    @Column
    private Boolean ppod;
    @Column
    private Boolean ppen;
    @Column
    private Boolean ppro;
    @Column
    private Boolean pbez;
    @Column
    private Boolean pmat;
    @Column
    private Boolean pali;
    @Column
    private Boolean plik;
    @Column
    private Boolean pvid;
    @Column
    private Boolean pzbipen;
    @Column
    private Boolean pdohdov;
    @Column
    private Boolean pdohdovdop;
    @Column
    private Boolean ppendov;
    @Column
    private String qnad;
    @Column
    private String knadprs;
    @Column
    private String lnadprs;
    @Column
    private String kfnr;
    @Column
    private String krah;
    @Column
    private String kdok8dr;
    @Column
    private String k1pv;
    @Column
    private String krahdt;
    @Column
    private String krahkt;
    @Column
    private String pbor;
    @Column
    private String kdokgrue;
    @Column
    private String qtoc;
    @Column
    private String kana;
    @Column
    private String kpod8dr;
    @Column
    private Boolean prazlik;
    @Column
    private String grafa;
    @Column
    private Boolean pvz;
    @Column
    private String qtar;
    @Column
    private String kfs6;
}

