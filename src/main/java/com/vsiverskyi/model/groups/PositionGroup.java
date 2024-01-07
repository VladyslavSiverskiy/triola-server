package com.vsiverskyi.model.groups;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NPOSGRU")
public class PositionGroup {
    @Id
    @Column(name = "KPOSGRU")
    private String code;

    @Column(name = "NPOSGRU")
    private String title;

}
