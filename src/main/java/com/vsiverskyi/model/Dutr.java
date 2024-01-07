package com.vsiverskyi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Dutr {
    @EmbeddedId
    private DutrKey dutrKey;

    @ManyToOne
    @MapsId("KTAB")
    @JoinColumn(name = "KTAB", referencedColumnName = "KTAB")
    private Employee employee;
    @ManyToOne
    @MapsId("KDOK")
    @JoinColumn(name = "KDOK", referencedColumnName = "KDOK")
    private Document document;
    @Column(name = "DSOC")
    private LocalDate socDate;
    @Column
    private Double s;
    @Column
    private String pgot;
    @Column(name = "DARC")
    private LocalDate archivationDate;
    @Column
    private String kroz;
    @ManyToOne
    @JoinColumn(name = "KPID", referencedColumnName = "KPID")
    private Unit unitCode;
    @Column
    private String kdil;
    @Column
    private String kide;

}
