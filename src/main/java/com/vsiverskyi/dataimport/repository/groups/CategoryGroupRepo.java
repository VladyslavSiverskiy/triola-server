package com.vsiverskyi.dataimport.repository.groups;

import com.vsiverskyi.dataimport.model.groups.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryGroupRepo extends JpaRepository<CategoryGroup, String> {
}
