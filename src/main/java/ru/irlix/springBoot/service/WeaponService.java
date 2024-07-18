package ru.irlix.springBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.irlix.springBoot.model.Weapon;
import ru.irlix.springBoot.repository.WeaponRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeaponService {

    private final WeaponRepository weaponRepo;

    public List<Weapon> findAll() {
        return weaponRepo.findAll();
    }

    public void add(Weapon weapon) {
        weaponRepo.add(weapon);
    }

    public void delete(String name) {
        weaponRepo.deleteById(name);
    }

    public Weapon findById(int id) {
        return weaponRepo.findById(id);
    }

    public void update(int id, Weapon weapon) {
        weaponRepo.update(id, weapon);
    }
}
