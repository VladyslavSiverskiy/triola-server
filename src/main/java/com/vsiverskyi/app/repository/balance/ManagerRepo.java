package com.vsiverskyi.app.repository.balance;

import com.vsiverskyi.app.model.balance.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Long> {
}
