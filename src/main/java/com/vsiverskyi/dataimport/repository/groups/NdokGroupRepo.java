package com.vsiverskyi.dataimport.repository.groups;

import com.vsiverskyi.dataimport.model.groups.DocumentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NdokGroupRepo extends JpaRepository<DocumentGroup, String> {
}
