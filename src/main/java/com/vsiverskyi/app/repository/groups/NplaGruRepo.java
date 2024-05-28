package com.vsiverskyi.app.repository.groups;

import com.vsiverskyi.app.model.groups.PlatVidomGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NplaGruRepo extends JpaRepository<PlatVidomGroup, String> {
}
