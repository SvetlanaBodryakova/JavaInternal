package org.example.App;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Calculator {
    protected AndroidDriver driver;

    public Calculator(AndroidDriver driver) {
        this.driver = driver;
    }

    private final By number3 = By.id("com.google.android.calculator:id/digit_3");
    private final By number9 = By.id("com.google.android.calculator:id/digit_9");
    private final By plus = By.id("com.google.android.calculator:id/op_add");
    private final By minus = By.id("com.google.android.calculator:id/op_sub");
    private final By multiply = By.id("com.google.android.calculator:id/op_mul");
    private final By divide = By.id("com.google.android.calculator:id/op_div");
    private final By equals = By.id("com.google.android.calculator:id/eq");
    private final By result = By.id("com.google.android.calculator:id/result_final");

    public double addition() {
        driver.findElement(number3).click();
        driver.findElement(plus).click();
        driver.findElement(number9).click();
        driver.findElement(equals).click();
        return Double.parseDouble(driver.findElement(result).getText());
    }

    public double subtraction() {
        driver.findElement(number9).click();
        driver.findElement(minus).click();
        driver.findElement(number3).click();
        driver.findElement(equals).click();
        return Double.parseDouble(driver.findElement(result).getText());
    }

    public double multiplication() {
        driver.findElement(number3).click();
        driver.findElement(multiply).click();
        driver.findElement(number9).click();
        driver.findElement(equals).click();
        return Double.parseDouble(driver.findElement(result).getText());
    }

    public double division() {
        driver.findElement(number9).click();
        driver.findElement(divide).click();
        driver.findElement(number3).click();
        driver.findElement(equals).click();
        return Double.parseDouble(driver.findElement(result).getText());
    }
}
