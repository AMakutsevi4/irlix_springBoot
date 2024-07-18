package ru.irlix.springBoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private int experience;
    private List<Employee> employees = new ArrayList<>();
}
