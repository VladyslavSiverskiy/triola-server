package com.vsiverskyi.app.repository.groups;

import com.vsiverskyi.app.model.groups.DocumentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NdokGroupRepo extends JpaRepository<DocumentGroup, String> {
}
