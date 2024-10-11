package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver chromeDriver;

    private Driver() {
    }

    public static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        return chromeDriver;
    }
}