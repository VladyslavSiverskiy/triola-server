package com.vsiverskyi.repository;

import com.vsiverskyi.model.Dutr;
import com.vsiverskyi.model.DutrKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DutrRepo extends JpaRepository <Dutr,DutrKey>{
}
