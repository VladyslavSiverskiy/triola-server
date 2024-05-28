package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Mdok;
import com.vsiverskyi.app.model.MdokKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdokRepo extends JpaRepository<Mdok, MdokKey> {
}
