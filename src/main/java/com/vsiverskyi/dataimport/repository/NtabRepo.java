package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NtabRepo extends JpaRepository<Employee, String> {
}
