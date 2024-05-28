package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepo extends JpaRepository<Unit, String> {
}
