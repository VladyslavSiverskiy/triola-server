package com.vsiverskyi.dataimport.repository.balance;

import com.vsiverskyi.dataimport.model.balance.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
