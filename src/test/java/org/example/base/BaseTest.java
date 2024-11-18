package org.example.base;

import io.appium.java_client.android.AndroidDriver;
import org.example.App.Calculator;
import org.example.utils.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static AndroidDriver driver;
    protected Calculator calculator = new Calculator(driver);

    @BeforeAll
    public static void setUp() {
        driver = Driver.getDriver();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }
}