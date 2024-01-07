package com.vsiverskyi.repository;

import com.vsiverskyi.model.Mdok;
import com.vsiverskyi.model.MdokKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdokRepo extends JpaRepository<Mdok, MdokKey> {
}
