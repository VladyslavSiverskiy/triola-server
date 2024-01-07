package com.vsiverskyi.model.graphs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "NGRA")
public class Graphic {

    @Id
    @Column(name = "KGRA")
    private String code;

    @Column(name = "NGRA")
    private String title;

    @Column(name = "PGRARED")
    private Boolean edited;

    @Column(name = "KILROBDNI")
    private Integer daysCount;


    @Column(name = "KILROBGOD")
    private Integer hoursCount;

    @Column(name = "GRATEMPL")
    private String graphTemplate;
}
