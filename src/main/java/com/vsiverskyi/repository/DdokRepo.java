package com.vsiverskyi.repository;

import com.vsiverskyi.model.Ddok;
import com.vsiverskyi.model.DdokKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DdokRepo extends JpaRepository<Ddok, DdokKey> {
}
