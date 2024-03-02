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
public class Ddok {
    @EmbeddedId
    private DdokKey ddokKey;

    @ManyToOne
    @MapsId("KTAB")
    @JoinColumn(name = "KTAB", referencedColumnName = "KTAB")
    private Employee employee;

    @ManyToOne
    @MapsId("KDOK")
    @JoinColumn(name = "KDOK", referencedColumnName = "KDOK")
    private Document document;
    @Column(name = "DKIN")
    private LocalDate endDate;

    @Column
    private String s;
    @Column
    private String pgot;
    @ManyToOne
    @JoinColumn(name = "KPID", referencedColumnName = "KPID")
    private Unit unitCode;
    @Column
    private String kint;
    @ManyToOne
    @JoinColumn(name = "KKAT", referencedColumnName = "KKAT")
    private Category categoryCode;
    @Column
    private String krah;

    @Column(name = "DARC")
    private LocalDate archivationDate;
    @Column
    private String kroz;
    @Column
    private String knomlik;
    @Column
    private Double tgod;
    @Column
    private Double tdni;
    @Column
    private String lerr;
    @Column
    private LocalDate dnak;
    @Column
    private String knak;
}
