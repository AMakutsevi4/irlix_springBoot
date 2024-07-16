package ru.irlix.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.irlix.springBoot.model.Weapon;
import ru.irlix.springBoot.repository.WeaponRepository;

@Controller
public class WeaponController {

    private final WeaponRepository weaponRepo;

    public WeaponController(WeaponRepository weaponRepo) {
        this.weaponRepo = weaponRepo;
    }

    @GetMapping("/weapons")
    public String showWeaponList(Model model) {
        model.addAttribute("weaponList", weaponRepo.findAll());
        return "weapons";
    }

    @GetMapping("/create")
    public String addPost(Model model) {
        model.addAttribute("post", new Weapon());
        return "createWeapon";
    }

    @PostMapping("/saveCreate")
    public String create(@ModelAttribute Weapon weapon) {
        weaponRepo.add(weapon);
        return "redirect:/weapons";
    }

    @PostMapping("/delete")
    public String deleteWeapon(@RequestParam("name") String name) {
        weaponRepo.deleteById(name);
        return "redirect:/weapons";
    }

}