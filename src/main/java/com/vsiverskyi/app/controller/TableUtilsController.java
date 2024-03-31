package com.vsiverskyi.app.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.EntityType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Клас для виконання службового функціоналу (наприклад дістати список таблиць з БД)
 */
@RestController
@RequestMapping("/utils")
@RequiredArgsConstructor
public class TableUtilsController {
    @PersistenceContext
    private EntityManager entityManager;

    public Set<EntityType<?>> getEntityTypes() {
        return entityManager.getMetamodel().getEntities();
    }

    @GetMapping("/tables")
    public ResponseEntity<List<String>> displayTableNames() {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<String> tables = new ArrayList<>();
        for (EntityType<?> entityType : entities) {
            Class<?> entityClass = entityType.getJavaType();
            // Check if @Table annotation is present
            if (entityClass.isAnnotationPresent(Table.class)) {
                Table tableAnnotation = entityClass.getAnnotation(Table.class);
                String tableName = tableAnnotation.name();
                System.out.println("Entity: " + entityType.getName() + ", Table: " + tableName);
                if (tableName.isEmpty()) {
                    tables.add(entityType.getName());
                }else{
                    tables.add(tableName);
                }
            } else {
                // If @Table is not present, use the entity name
                String tableName = entityType.getName();
                System.out.println("Table: " + tableName);
            }
        }
        return ResponseEntity.ok(tables.stream().map(String::toLowerCase).collect(Collectors.toList()));
    }
}
