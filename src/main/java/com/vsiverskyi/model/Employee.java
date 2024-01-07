package com.vsiverskyi.model;

import com.vsiverskyi.model.groups.DocumentGroup;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "NTAB")
public class Employee {
    @Column(name = "KPOL")
    private String gender;
    @ManyToOne
    @JoinColumn(name = "KPID", referencedColumnName = "KPID")
    private Unit unitCode;
    @Id
    @Column(name = "KTAB")
    private String tabNumber;
    @Column(name = "NTAB")
    private String name;
    @Column(name = "KIDE")
    private String kide;
    @Column(name = "DPRY")
    private LocalDate dataPryuniatia;
    @Column(name = "DZVI")
    private LocalDate dataZvilnenia;
    @Column(name = "DROZZVI")
    private LocalDate drozzvi;
    @Column(name = "KPOD")
    private String kpod;
    @Column(name = "KAVA")
    private Short kava;
    @Column(name = "NTABMIN")
    private String nameMin;
    @ManyToOne
    @JoinColumn(name = "KKAT", referencedColumnName = "KKAT")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "KPOS", referencedColumnName = "KPOS")
    private Position positionCode;
    @Column
    private Short kper;
    @Column
    private String krah;
    @Column
    private String qsta;
    //сума окладу
    @Column(name = "SOKL")
    private String sokl;
    @Column
    private String kkla;
    @Column
    private String kror;
    @Column
    private LocalDate dbaz;
    private String kdpa;
    @Column
    private Boolean pdruk;
    @Column
    private LocalDate drestruct;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//Для позначення NTAB
