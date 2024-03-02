package com.vsiverskyi.dataimport.repository.balance;

import com.vsiverskyi.dataimport.model.balance.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<Balance, String> {
}
