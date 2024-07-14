package ru.irlix.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @GetMapping("/helloWorld")
    public String seyHello() {
        return "helloWorld";
    }
}
