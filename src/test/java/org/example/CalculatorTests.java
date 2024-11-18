package org.example;

import org.example.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests extends BaseTest {

    @Test
    @DisplayName("Проверка функциональности сложения чисел")
    public void testAddition() {
        double result = calculator.addition();
        assertEquals(12, result);
    }

    @Test
    @DisplayName("Проверка функциональности вычитания чисел")
    public void testSubtraction() {
        double result = calculator.subtraction();
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Проверка функциональности умножения чисел")
    public void testMultiplication() {
        double result = calculator.multiplication();
        assertEquals(27, result);
    }

    @Test
    @DisplayName("Проверка функциональности деления чисел")
    public void testDivision() {
        double result = calculator.division();
        assertEquals(3, result);
    }
}