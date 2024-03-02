package com.vsiverskyi.dataimport.repository.groups;

import com.vsiverskyi.dataimport.model.groups.PlatVidomGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NplaGruRepo extends JpaRepository<PlatVidomGroup, String> {
}
