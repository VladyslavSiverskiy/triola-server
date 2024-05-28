package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NtabRepo extends JpaRepository<Employee, String> {
}
