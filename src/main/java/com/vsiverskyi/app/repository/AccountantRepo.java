package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountantRepo extends JpaRepository<Accountant, String> {
}
