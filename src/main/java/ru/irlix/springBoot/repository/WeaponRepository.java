package ru.irlix.springBoot.repository;

import org.springframework.stereotype.Repository;
import ru.irlix.springBoot.model.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class WeaponRepository {
    private final AtomicInteger index = new AtomicInteger();

    private final List<Weapon> weaponList = new ArrayList<>();

    public void add(Weapon weapon) {
        weapon.setId(index.incrementAndGet());
        weaponList.add(weapon);
    }

    public List<Weapon> findAll() {
        return weaponList;
    }

    public void deleteById(String name) {
        weaponList.removeIf(w -> w.getName().equals(name));
    }

    public Weapon findById(int id) {
        return weaponList.stream().filter(w -> w.getId() == id).findFirst().orElse(null);
    }

    public void update(int id, Weapon weapon) {
        Weapon update = findById(id);
        update.setName(weapon.getName());
        update.setType(weapon.getType());
        update.setSizeMagazine(weapon.getSizeMagazine());

    }
}

