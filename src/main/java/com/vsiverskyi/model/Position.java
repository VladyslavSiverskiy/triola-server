package com.vsiverskyi.model;


import com.vsiverskyi.model.groups.CategoryGroup;
import com.vsiverskyi.model.groups.PositionGroup;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

//Для посад
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NPOS")
public class Position {

    @Column
    private String kror;
    @Column
    private LocalDate dbaz;
    @Column
    private Double sokl;
    @Column
    private Double qokl;
    @Id
    @Column(name = "KPOS")
    private String code;
    @Column(name = "NPOS")
    private String title;
    // код групи посади
    @ManyToOne
    @JoinColumn(name = "KPOSGRU", referencedColumnName = "KPOSGRU")
    private PositionGroup positionGroup;
    @Column(name = "NPOSMAX")
    private String titleMax;
    @Column(name = "KPRO")
    private String codeKP;
    @Column(name= "KKZPP")
    private String codeZKPTTR;
    @Column(name = "NPRO")
    private String namePRO;
    @Column(name = "QPRE")
    private Double qpre;
    @Column(name = "QPRE22")
    private Double qpre22;
}
