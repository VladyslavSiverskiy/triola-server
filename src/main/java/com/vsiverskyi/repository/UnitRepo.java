package com.vsiverskyi.repository;

import com.vsiverskyi.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepo extends JpaRepository<Unit, String> {
}
