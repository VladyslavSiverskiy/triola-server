package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Mnar;
import com.vsiverskyi.dataimport.model.MnarKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnarRepo extends JpaRepository<Mnar, MnarKey> {
}
