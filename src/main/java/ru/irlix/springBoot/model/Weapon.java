package ru.irlix.springBoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {
    private int id;
    private String name;
    private String type;
    private int sizeMagazine;

}
