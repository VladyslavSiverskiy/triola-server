package com.vsiverskyi.repository.balance;

import com.vsiverskyi.model.balance.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
