package com.vsiverskyi.dataimport.repository.balance;

import com.vsiverskyi.dataimport.model.balance.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Long> {
}
