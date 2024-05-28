package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Ddok;
import com.vsiverskyi.app.model.DdokKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DdokRepo extends JpaRepository<Ddok, DdokKey> {
}
