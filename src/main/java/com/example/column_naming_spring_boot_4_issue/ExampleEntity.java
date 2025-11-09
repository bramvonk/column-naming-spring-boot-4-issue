package com.example.column_naming_spring_boot_4_issue;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExampleEntity {
    @Id
    private int id;

    private String columnWith1Number;
}
