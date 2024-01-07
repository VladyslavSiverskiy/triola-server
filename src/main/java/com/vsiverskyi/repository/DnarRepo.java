package com.vsiverskyi.repository;

import com.vsiverskyi.model.Dnar;
import com.vsiverskyi.model.DnarKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnarRepo extends JpaRepository<Dnar, DnarKey> {
}
