package org.example.base;

import org.example.pages.BasketPage;
import org.example.pages.StartingPage;
import org.example.pages.base.BasePage;
import org.example.utils.Driver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected BasePage basePage;
    protected StartingPage startingPage;
    protected BasketPage basketPage;
    protected static WebDriver driver;
    public static final String BASE_URL = "https://wildberries.ru";

    @BeforeTest
    public static void load() {
        driver = Driver.getChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void setPage() {
        startingPage = new StartingPage(driver);
        basketPage = new BasketPage(driver);
    }

    @BeforeMethod
    public void openBaseURL() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        try {
            driver.get(BASE_URL);
            basePage = new BasePage(driver);
        } catch (Exception e) {
            System.out.println("Страница не загружается");
        }
        try {
            basePage.clickCookies();
        } catch (TimeoutException e) {
            System.out.println("Cookies не отображаются на странице");
        }
    }

    @AfterTest(alwaysRun = true)
    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }
}