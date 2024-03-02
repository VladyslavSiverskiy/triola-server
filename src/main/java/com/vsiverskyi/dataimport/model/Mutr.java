package com.vsiverskyi.dataimport.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MUTR")
public class Mutr {
    @EmbeddedId
    private MutrKey mutrKey;
    @Column
    private Double s;
    @Column
    private String pgot;
    @ManyToOne
    @JoinColumn(name = "KPID", referencedColumnName = "KPID")
    private Unit unitCode;
    @Column
    private String kdil;
    @Column(name = "DARC")
    private LocalDate archivationDate;
    @Column
    private String kroz;
    @Column
    private String qpen;
}
