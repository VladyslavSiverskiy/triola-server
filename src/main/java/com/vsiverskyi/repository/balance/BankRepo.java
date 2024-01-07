package com.vsiverskyi.repository.balance;

import com.vsiverskyi.model.balance.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank, Long> {

}
