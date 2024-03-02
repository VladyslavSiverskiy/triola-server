package com.vsiverskyi.dataimport.controller;

import com.vsiverskyi.dataimport.repository.EmployeeRepo;
import com.vsiverskyi.dataimport.repository.UnitRepo;
import com.vsiverskyi.dataimport.repository.balance.BalanceRepo;
import com.vsiverskyi.dataimport.service.scanning.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final EmployeeRepo employeeRepo;
    private final UnitRepo unitRepo;
    private final BalanceRepo balanceRepo;
    private final NbalScan nbalScan;
    private final NpidScan npidScan;
    private final NkatScan nkatScan;
    private final NposScan nposScan;
    private final NtabScan ntabScan;
    private final NdokScan ndokScan;
    private final NrobNgraScan nrobNgraScan;
    private final MutrDutrScan mutrDutrScan;
    private final MnarDnarScan mnarDnarScan;
    private final MdokDdokScan mdokDdokScan;

    @PostMapping("/employee")
    public void test() {
//        Employee employee = new Employee();
//        employee.setName("Oleg");
//        employeeRepo.save(employee);

//        Balance balance = new Balance();
//        balance.setCode("02");
//        balanceRepo.save(balance);
//        Unit unit = new Unit();
//        unit.setCode("01000");
//        unit.setBalance(balance);
//        unit.setTitle("військові");
//        unitRepo.save(unit);
    }

    @GetMapping
    public void scan() {
        nbalScan.scanBalances();
        npidScan.scanUnits();
        nkatScan.scanCategories();
        nposScan.scanPositions();
        nrobNgraScan.scanGraphs();
        ndokScan.scanDocuments();
        ntabScan.scanNtab();
        mutrDutrScan.scanMutrDutr();
        mnarDnarScan.scanMnarDnar();
        mdokDdokScan.scanMdokDdok();
    }
}
