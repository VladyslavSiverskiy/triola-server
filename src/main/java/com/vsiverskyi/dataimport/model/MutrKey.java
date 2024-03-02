package com.vsiverskyi.dataimport.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Embeddable
public class MutrKey implements Serializable {
    @Column(name = "KTAB")
    private String tabNumberCode;
    @Column(name = "KDOK")
    private String documentCode;
    @Column(name = "DPOC")
    private LocalDate startDate;
}
