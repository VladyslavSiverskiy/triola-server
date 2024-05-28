package com.vsiverskyi.app.repository.groups;

import com.vsiverskyi.app.model.groups.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryGroupRepo extends JpaRepository<CategoryGroup, String> {
}
