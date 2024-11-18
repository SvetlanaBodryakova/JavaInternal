package org.example.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;

public class Driver {
    private static AndroidDriver driver;
    private static final String currentWorkingDir = System.getProperty("user.dir");
    private static final String relativePath = "./src/main/resources/calculator.apk";
    private static final String absolutePath = String.valueOf(Paths.get(currentWorkingDir,
            relativePath).toAbsolutePath().normalize());

    private Driver() {
    }

    private static AndroidDriver initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Medium Phone");
        capabilities.setCapability("app", absolutePath);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            return driver = initialize();
        }
        return driver;
    }
}