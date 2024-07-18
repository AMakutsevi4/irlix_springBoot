package ru.irlix.springBoot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.irlix.springBoot.model.Weapon;
import ru.irlix.springBoot.service.WeaponService;

@Controller
@RequestMapping("/weapons")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponService weaponService;


    @GetMapping()
    public String showWeaponList(Model model) {
        model.addAttribute("weaponList", weaponService.findAll());
        return "weapons";
    }

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("post", new Weapon());
        return "createWeapon";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Weapon weapon) {
        weaponService.add(weapon);
        return "redirect:/weapons";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("name") String name) {
        weaponService.delete(name);
        return "redirect:/weapons";
    }

    @GetMapping("/updates/{weapon_id}")
    public String updates(@PathVariable int weapon_id, Model model) {
        Weapon weapon = weaponService.findById(weapon_id);
            model.addAttribute("weapon", weapon);
            return "updateWeapon";

    }

    @PostMapping("/updates/{weapon_id}")
    public String updates(@PathVariable int weapon_id, @ModelAttribute Weapon weapon) {
        weaponService.update(weapon_id, weapon);
        return "redirect:/weapons";
    }
}