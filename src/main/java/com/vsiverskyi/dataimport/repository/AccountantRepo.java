package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountantRepo extends JpaRepository<Accountant, String> {
}
