package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Dnar;
import com.vsiverskyi.dataimport.model.DnarKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnarRepo extends JpaRepository<Dnar, DnarKey> {
}
