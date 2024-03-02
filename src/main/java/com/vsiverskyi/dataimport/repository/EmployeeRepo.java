package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
}
