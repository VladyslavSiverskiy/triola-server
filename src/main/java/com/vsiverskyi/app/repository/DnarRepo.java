package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Dnar;
import com.vsiverskyi.app.model.DnarKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnarRepo extends JpaRepository<Dnar, DnarKey> {
}
