package com.vsiverskyi.dataimport.repository.groups;

import com.vsiverskyi.dataimport.model.groups.BalanceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceGroupRepo extends JpaRepository<BalanceGroup, String> {
}
