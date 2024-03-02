package com.vsiverskyi.dataimport.repository.balance;

import com.vsiverskyi.dataimport.model.balance.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank, Long> {

}
