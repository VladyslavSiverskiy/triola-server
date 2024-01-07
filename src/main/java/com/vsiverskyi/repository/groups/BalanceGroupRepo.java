package com.vsiverskyi.repository.groups;

import com.vsiverskyi.model.groups.BalanceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceGroupRepo extends JpaRepository<BalanceGroup, String> {
}
