package com.vsiverskyi.dataimport.repository.groups;

import com.vsiverskyi.dataimport.model.groups.UnitGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NpidGruRepo extends JpaRepository<UnitGroup, String> {
}
