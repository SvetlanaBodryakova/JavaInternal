package org.example.base;

import org.example.pages.base.BasePage;
import org.example.utils.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected BasePage basePage;
    protected static WebDriver driver;
    public static final String BASE_URL = "https://mts.by";

    @BeforeAll
    public static void load() {
        driver = Driver.getChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void openBaseURL() {
        driver.get(BASE_URL);
        basePage = new BasePage(driver);
        try {
            basePage.clickCookies();
        } catch (TimeoutException e) {
            System.out.println("Cookies не отображаются на странице");
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
