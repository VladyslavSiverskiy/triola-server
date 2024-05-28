package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.DutrKey;
import com.vsiverskyi.app.model.Dutr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DutrRepo extends JpaRepository <Dutr, DutrKey>{
}
