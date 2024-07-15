package ru.irlix.springBoot.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculatorRepository {

    public final List<String> data = new ArrayList<>();

    public String getResultHistory(String operation, double arg1, double arg2, double result) {
        return arg1 + " " + operation + " " + arg2 + " = " + result;
    }

    public double resultInjection(String operation, double arg1, double arg2) {
        double result = 0.0;
        if (operation.equals("+")) {
            result = arg1 + arg2;
        }
        if (operation.equals("-")) {
            result = arg1 - arg2;
        }
        if (operation.equals("*")) {
            result = arg1 * arg2;
        }
        if (operation.equals("/")) {
            result = arg1 / arg2;
        }
        return result;
    }
}
