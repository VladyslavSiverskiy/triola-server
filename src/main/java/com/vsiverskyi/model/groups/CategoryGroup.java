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
@Table(name = "NKATGRU")
public class CategoryGroup {
    //код групи
    @Id
    @Column(name = "KKATGRU")
    private String code;

    @Column(name = "NKATGRU")
    private String title;
}
