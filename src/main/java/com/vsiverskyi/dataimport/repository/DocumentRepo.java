package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document, String> {
}
