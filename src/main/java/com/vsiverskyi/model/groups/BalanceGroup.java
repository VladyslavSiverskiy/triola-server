package com.vsiverskyi.model.groups;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "NBALGRU")
@NoArgsConstructor
@AllArgsConstructor
public class BalanceGroup {
    //код групи
    @Id
    @Column(name = "KBALGRU")
    private String code;

    @Column(name = "NBALGRU")
    private String title;
}
