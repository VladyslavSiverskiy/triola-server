package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Mdok;
import com.vsiverskyi.dataimport.model.MdokKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdokRepo extends JpaRepository<Mdok, MdokKey> {
}
