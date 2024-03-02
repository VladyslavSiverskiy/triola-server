package com.vsiverskyi.dataimport.model;

import com.vsiverskyi.dataimport.model.groups.CategoryGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Клас для позначення Категорій
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NKAT")
public class Category {
    @Id
    @Column(name = "KKAT")
    private String code;

    @Column(name = "NKAT")
    private String title;

    @ManyToOne
    @JoinColumn(name = "KKATGRU", referencedColumnName = "KKATGRU")
    private CategoryGroup categoryGroup;

    //Сума окладу
    @Column(name = "SOKL")
    private BigDecimal oklSum;

    @Column
    private String nkatmax;

    @Column
    private String kkatokl;
}
