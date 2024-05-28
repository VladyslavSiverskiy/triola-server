package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document, String> {
}
