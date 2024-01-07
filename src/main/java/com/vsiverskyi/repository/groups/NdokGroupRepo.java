package com.vsiverskyi.repository.groups;

import com.vsiverskyi.model.groups.DocumentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NdokGroupRepo extends JpaRepository<DocumentGroup, String> {
}
