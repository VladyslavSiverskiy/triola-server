package com.vsiverskyi.dataimport.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Dnar {

    @EmbeddedId
    private DnarKey dnarKey;

    @ManyToOne
    @MapsId("KTAB")
    @JoinColumn(name = "KTAB", referencedColumnName = "KTAB")
    private Employee employee;
    @ManyToOne
    @MapsId("KDOK")
    @JoinColumn(name = "KDOK", referencedColumnName = "KDOK")
    private Document document;
    @Column(name = "DSOC")
    private LocalDate socDate;
    @Column(name = "DPOD")
    private LocalDate podDate;
    @Column
    private Double tdni;
    @Column
    private Double tgod;
    @Column
    private String s;
    @Column
    private Double p;
    @Column
    private String kide;
    @Column
    private String kkzo;
    @Column
    private String ktyp;
    @ManyToOne
    @JoinColumn(name = "KPID", referencedColumnName = "KPID")
    private Unit unitCode;
    @ManyToOne
    @JoinColumn(name = "KKAT", referencedColumnName = "KKAT")
    private Category categoryCode;
    @ManyToOne
    @JoinColumn(name = "KPOS", referencedColumnName = "KPOS")
    private Position position;
    @Column
    private String kper;
    @Column
    private String krah;
    @Column
    private String kint;
    @Column
    private Double snarpen;
    @Column(name = "DNAK")
    private LocalDate dnak;
    @Column
    private String knak;
    @Column(name = "DARC")
    private LocalDate archivationDate;
    @Column
    private Double tdniold;
    @Column
    private Double tgodold;
    @Column
    private String sold;
    @Column
    private Double tviold;
    @Column
    private Double spen;
    @Column
    private Boolean pinv;

}
