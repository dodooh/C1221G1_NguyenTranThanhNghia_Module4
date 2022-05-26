package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public Double calc(Double number1, Double number2, String operator) {
        switch (operator) {
            case "Addition(+)":
                return number1 + number2;
            case "Subtraction(-)":
                return number1 - number2;
            case "Multiplication(*)":
                return number1 * number2;
            case "Division(/)":
                if (number2 == 0) {
                    throw new ArithmeticException("Khong the chia cho 0");
                } else
                return number1 / number2;
            default:
                return null;
        }
    }
}
