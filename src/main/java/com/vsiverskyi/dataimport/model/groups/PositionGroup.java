package com.vsiverskyi.dataimport.model.groups;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@ToString
@Table(name = "NPOSGRU")
public class PositionGroup {
    @Id
    @Column(name = "KPOSGRU")
    private String code;

    @Column(name = "NPOSGRU")
    private String title;

}
