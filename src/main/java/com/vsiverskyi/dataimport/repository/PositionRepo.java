package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Position;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PositionRepo extends JpaRepository<Position, String> {
    @Modifying
    @Query("UPDATE Position p SET p.code = :newValue WHERE p.code = :codeValue")
    void updateByCode(@Param("codeValue") String code, @Param("newValue") String newValue);
}
