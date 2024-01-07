package com.vsiverskyi.model.balance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NBALKER")
public class Manager {
    @Id
    @Column(name = "NBALKER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NKER")
    private String nameAndSurname;
    @Column(name = "KIDEKER")
    private String idCode;
    @Column(name = "KTELKER")
    private String phone;
    //Посада керівника
    @Column(name = "NPOSKER")
    private String position;
}