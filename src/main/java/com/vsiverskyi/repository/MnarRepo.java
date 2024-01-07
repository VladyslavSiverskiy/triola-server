package com.vsiverskyi.repository;

import com.vsiverskyi.model.Mnar;
import com.vsiverskyi.model.MnarKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnarRepo extends JpaRepository<Mnar, MnarKey> {
}
