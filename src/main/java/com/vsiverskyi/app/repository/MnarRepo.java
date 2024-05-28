package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Mnar;
import com.vsiverskyi.app.model.MnarKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnarRepo extends JpaRepository<Mnar, MnarKey> {
}
