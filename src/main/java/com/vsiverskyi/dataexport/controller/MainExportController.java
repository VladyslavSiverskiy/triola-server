package com.vsiverskyi.dataexport.controller;

import com.vsiverskyi.dataexport.service.ExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/export")
@RequiredArgsConstructor
public class MainExportController {

    private final ExportService exportService;

    @GetMapping
    public ResponseEntity<Boolean> exportData() throws FileNotFoundException {
        exportService.exportData();
        return ResponseEntity.ok(true);
    }
}
