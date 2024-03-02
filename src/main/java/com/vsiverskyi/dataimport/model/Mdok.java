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
@Table(name = "MDOK")
public class Mdok {

    @EmbeddedId
    private MdokKey mdokKey;

    @ManyToOne
    @MapsId("KTAB")
    @JoinColumn(name = "KTAB", referencedColumnName = "KTAB")
    private Employee employee;

    @ManyToOne
    @MapsId("KDOK")
    @JoinColumn(name = "KDOK", referencedColumnName = "KDOK")
    private Document document;

//    @MapsId("DPOC")
//    @Column(name = "DPOC")
//    private LocalDate startDate;

    @Column(name = "DKIN")
    private LocalDate endDate;

    @Column
    private String s;

    @Column
    private String kint;

    @Column(name = "DARC")
    private LocalDate archivationDate;

    @Column
    private String knomlik;
    @Column
    private LocalDate dnak;

    @Column
    private String knak;
}



