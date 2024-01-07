package com.vsiverskyi.repository.balance;

import com.vsiverskyi.model.balance.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Long> {
}
