package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.example.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Калькулятор Google")
@Feature("Арифметические действия")
@Owner("Svetlana Bodryakova")
public class CalculatorTests extends BaseTest {

    @Test
    @Story("Сложение")
    @Description("Проверка функциональности сложения чисел")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddition() {
        double result = calculator.addition();
        assertEquals(12, result);
    }

    @Test
    @Story("Вычитание")
    @Description("Проверка функциональности вычитания чисел")
    @Severity(SeverityLevel.CRITICAL)
    public void testSubtraction() {
        double result = calculator.subtraction();
        assertEquals(6, result);
    }

    @Test
    @Story("Умножение")
    @Description("Проверка функциональности умножения чисел")
    @Severity(SeverityLevel.CRITICAL)
    public void testMultiplication() {
        double result = calculator.multiplication();
        assertEquals(27, result);
    }

    @Test
    @Story("Деление")
    @Description("Проверка функциональности деления чисел")
    @Severity(SeverityLevel.CRITICAL)
    public void testDivision() {
        double result = calculator.division();
        assertEquals(3, result);
    }
}