package com.vsiverskyi.repository.groups;

import com.vsiverskyi.model.groups.PlatVidomGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NplaGruRepo extends JpaRepository<PlatVidomGroup, String> {
}
