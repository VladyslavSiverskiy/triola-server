package com.vsiverskyi.repository;

import com.vsiverskyi.model.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountantRepo extends JpaRepository<Accountant, String> {
}
