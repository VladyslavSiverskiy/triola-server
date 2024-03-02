package com.vsiverskyi.dataimport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

//Опис бухгалтера
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NBUH")
public class Accountant {

    @Id
    @Column(name = "KBUH")
    private String code;

    //ім`я бухгалтера
    @Column(name = "NBUH")
    private String name;

}
