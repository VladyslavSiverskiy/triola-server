package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.DutrKey;
import com.vsiverskyi.dataimport.model.Dutr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DutrRepo extends JpaRepository <Dutr, DutrKey>{
}
