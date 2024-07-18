package ru.irlix.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("managersAndEmployees")
public class EditController {

    @GetMapping
    public String listEmployees() {
        return "managersAndEmployees";
    }
}
