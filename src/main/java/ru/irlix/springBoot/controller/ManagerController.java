package ru.irlix.springBoot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.irlix.springBoot.model.Manager;
import ru.irlix.springBoot.service.ManagerService;


@Controller
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping
    public String listManagers(Model model) {
        model.addAttribute("managers", managerService.getAllManagers());
        return "managers";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("manager", new Manager());
        return "managerAdd";
    }

    @PostMapping
    public String saveManager(@ModelAttribute Manager manager) {
        managerService.saveManager(manager);
        return "redirect:/managers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Manager manager = managerService.getManagerById(id);
        if (manager != null) {
            model.addAttribute("manager", manager);
            return "managerAdd";
        }
        return "redirect:/managers";
    }

    @GetMapping("/delete/{id}")
    public String deleteManager(@PathVariable("id") Long id) {
        managerService.deleteManager(id);
        return "redirect:/managers";
    }
}