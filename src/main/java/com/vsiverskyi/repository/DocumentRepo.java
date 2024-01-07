package com.vsiverskyi.repository;

import com.vsiverskyi.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document, String> {
}
