package com.vsiverskyi.app.repository.balance;

import com.vsiverskyi.app.model.balance.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<Balance, String> {
}
