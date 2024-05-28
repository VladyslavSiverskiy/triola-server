package com.vsiverskyi.app.model.balance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NBALBANK")
public class Bank {

    @Id
    @Column(name = "NBALBANK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //назва банку
    @Column(name = "NBAN")
    private String title;
    @Column(name = "KROZRAH")
    private String krozrah;
    @Column(name = "MFO")
    private String mfo;
}
