package com.vsiverskyi.app.repository.balance;

import com.vsiverskyi.app.model.balance.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank, Long> {

}
