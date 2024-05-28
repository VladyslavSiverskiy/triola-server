package com.vsiverskyi.app.repository.groups;

import com.vsiverskyi.app.model.groups.UnitGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NpidGruRepo extends JpaRepository<UnitGroup, String> {
}
