package com.vsiverskyi.repository.groups;

import com.vsiverskyi.model.groups.UnitGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NpidGruRepo extends JpaRepository<UnitGroup, String> {
}
