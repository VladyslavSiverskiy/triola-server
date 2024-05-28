package com.vsiverskyi.app.repository.balance;

import com.vsiverskyi.app.model.balance.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
