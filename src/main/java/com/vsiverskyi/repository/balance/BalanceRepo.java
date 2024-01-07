package com.vsiverskyi.repository.balance;

import com.vsiverskyi.model.balance.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<Balance, String> {
}
