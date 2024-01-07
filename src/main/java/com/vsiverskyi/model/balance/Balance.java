package com.vsiverskyi.model.balance;


import com.vsiverskyi.model.groups.BalanceGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Клас для позначення балансу
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NBAL")
public class Balance {

    @Id
    @Column(name = "KBAL")
    private String code;
    @ManyToOne
    @JoinColumn(name = "KBALGRU", referencedColumnName = "KBALGRU")
    private BalanceGroup balanceGroup;
    @Column(name = "NBAL")
    private String title;
    @ManyToOne
    @JoinColumn(name = "NFIR_ID")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "NBALBANK_ID")
    private Bank bank;
    @ManyToOne
    @JoinColumn(name = "NBALKER_ID")
    private Manager manager;
    @Column(name = "NBUH")
    private String accountantNameAndSurname;
    @Column(name = "KIDEBUH")
    private String accountantIdCode;
    @Column(name = "KTELBUH")
    private String accountantPhone;
    @Column(name = "NPOSBUH")
    private String accountantPosition;
    //Код області
    @Column(name = "KOBL")
    private String regionCode;
    @Column(name = "KDPA")
    private String codeDpi;
    //Дпі, єдрпоу
    @Column(name = "KIDEDPA")
    private String edrpou;
    //Назва дпі
    @Column(name = "NDPA")
    private String dpiName;
    @Column(name = "KREESOC")
    private String registerNumber;
    @Column(name = "KREESOC2")
    private String registerNumber2;
    //Назва фонду
    @Column(name = "NSOC")
    private String fondName;
    @Column(name = "NKERSOC")
    private String voManagerName;
    @Column(name = "KROZRAHSOC")
    private String bankRR;
    @Column(name = "MFOSOC")
    private String mfoSoc;
    @Column(name = "LVOSOC")
    private Boolean voSoc;
    @Column(name = "KRAHKT")
    private Long orderCount;
    @Column(name = "PNOTBAN")
    private Boolean doNotTransferToBank;
    @Column(name = "NMO5")
    private String nmo5;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
