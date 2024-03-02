package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Ddok;
import com.vsiverskyi.dataimport.model.DdokKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DdokRepo extends JpaRepository<Ddok, DdokKey> {
}
