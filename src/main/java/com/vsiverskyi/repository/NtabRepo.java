package com.vsiverskyi.repository;

import com.vsiverskyi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NtabRepo extends JpaRepository<Employee, String> {
}
