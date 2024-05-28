package com.vsiverskyi.app.model.balance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NBALCOMP")
public class Company {
    @Id
    @Column(name = "NFIR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NFIR")
    private String fullTitle;
    @Column(name = "NFIRIN")
    private String shortTitle;
    @Column(name = "KIDEFIR")
    private String edrpou;
    @Column(name = "KIDEFIRPEN")
    private String pfEdrpou;
    @Column(name = "NADRFIR")
    private String address;
    @Column(name = "KTELFIR")
    private String phone;
    @Column(name = "KPK")
    private String kpkKfk;
}
