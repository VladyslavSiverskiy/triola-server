package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepo extends JpaRepository<Unit, String> {
}
