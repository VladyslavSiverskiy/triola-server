package com.vsiverskyi.model.groups;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NPIDGRU")
public class UnitGroup {

    //код групи
    @Id
    @Column(name = "KPIDGRU")
    private String code;
    @Column(name = "NPIDGRU")
    private String title;
    @Column
    private String kdpa;
    @Column
    private String nker2;
    @Column
    private String nbuh2;
    @Column
    private String nvyk;
}
