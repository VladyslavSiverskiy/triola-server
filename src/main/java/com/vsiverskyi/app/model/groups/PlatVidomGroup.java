package com.vsiverskyi.app.model.groups;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

// Групування по платіжних відомостях
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NPLAGRU")
public class PlatVidomGroup {

    //код групи
    @Id
    @Column(name = "KPLAGRU")
    private String code;

    @Column(name = "NPLAGRU")
    private String title;
}
