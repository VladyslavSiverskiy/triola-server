package com.vsiverskyi.app.repository.groups;

import com.vsiverskyi.app.model.groups.BalanceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceGroupRepo extends JpaRepository<BalanceGroup, String> {
}
