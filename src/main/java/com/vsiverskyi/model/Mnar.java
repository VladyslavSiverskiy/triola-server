package com.vsiverskyi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MNAR")
public class Mnar {
    @EmbeddedId
    private MnarKey mnarKey;
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
    private String kkzo;
    @Column
    private String ktyp;
    @Column
    private String kpen;
    @Column
    private Double tvid;
    @Column
    private String pgot;
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
    private Double spen;
    @Column
    private Boolean pinv;
    @Column
    private Double snarpen;
    @Column
    private String kide;
    @Column
    private Double p;
    @Column(name = "DNAK")
    private LocalDate dnak;
    @Column
    private String knak;
    @Column(name = "DARC")
    private LocalDate archivationDate;
}
