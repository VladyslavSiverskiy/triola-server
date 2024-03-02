package com.vsiverskyi.dataimport.model.graphs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NROB")
public class GraphNROB {

    @Id
    @Column(name = "DPOC")
    private LocalDate dpoc;
    @Column(name = "TGOD01")
    private Double tgod01;
    @Column(name = "TGOD02")
    private Double tgod02;
    @Column(name = "TGOD03")
    private Double tgod03;
    @Column(name = "TGOD04")
    private Double tgod04;

}
