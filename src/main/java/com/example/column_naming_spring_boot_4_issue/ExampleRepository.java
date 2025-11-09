package com.example.column_naming_spring_boot_4_issue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {
    @Query(value = "SELECT column_with1number FROM example_entity", nativeQuery = true)
    List<String> getColumnWith1Number();

    @Query(value = "SELECT column_with1_number FROM example_entity", nativeQuery = true)
    List<String> getColumnWith1NumberWithSpringBoot4Naming();
}
