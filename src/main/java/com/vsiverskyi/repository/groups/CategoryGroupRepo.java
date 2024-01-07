package com.vsiverskyi.repository.groups;

import com.vsiverskyi.model.groups.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryGroupRepo extends JpaRepository<CategoryGroup, String> {
}
