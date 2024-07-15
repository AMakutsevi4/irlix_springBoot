package ru.irlix.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.irlix.springBoot.repository.CalculatorRepository;

@Controller
public class CalculatorController {

    private final CalculatorRepository calcRepo;

    public CalculatorController(CalculatorRepository calcRepo) {
        this.calcRepo = calcRepo;
    }

    @GetMapping("calculator")
    public String showCalculator(Model model) {
        model.addAttribute("data", calcRepo.data);
        return "calculator";
    }

    @PostMapping("calculator")
    public String calculate(
            @RequestParam("arg1") double arg1,
            @RequestParam("arg2") double arg2,
            @RequestParam("operation") String operation,
            Model model) {
        double result = calcRepo.resultInjection(operation, arg1, arg2);

        calcRepo.data.add(
                calcRepo.getResultHistory(operation, arg1, arg2, result));
        model.addAttribute("result", result);
        model.addAttribute("data", calcRepo.data);
        return "calculator";
    }
}
