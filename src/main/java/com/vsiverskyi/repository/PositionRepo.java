package com.vsiverskyi.repository;

import com.vsiverskyi.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepo extends JpaRepository<Position, String> {
}
