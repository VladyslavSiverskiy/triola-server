package com.vsiverskyi.app.model;

import com.vsiverskyi.app.model.groups.PlatVidomGroup;
import com.vsiverskyi.app.model.balance.Balance;
import com.vsiverskyi.app.model.groups.UnitGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Клас для позначення підрозділу
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NPID")
public class Unit {
    @Id
    @Column(name = "KPID")
    private String code;
    @Column(name = "NPID")
    private String title;
    @ManyToOne
    @JoinColumn(name = "KBAL", referencedColumnName = "KBAL")
    private Balance balance;
    @ManyToOne
    @JoinColumn(name = "KPIDGRU", referencedColumnName = "KPIDGRU")
    private UnitGroup unitGroup;
    @ManyToOne
    @JoinColumn(name = "KBUH", referencedColumnName = "KBUH")
    private Accountant accountant;
    @ManyToOne
    @JoinColumn(name = "KPLAGRU", referencedColumnName = "KPLAGRU")
    private PlatVidomGroup nplagroup;
    @Column
    private String lgrokas;
    @Column
    private String kkas;
    @Column
    private String ktab;
    @Column
    private String kide;
    @Column
    private String kdpa;
    @Column
    private Double qroz;
    @Column
    private Boolean lfolder;
    @Column
    private Boolean kpidup;
}
