package org.example.base;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.example.App.Calculator;
import org.example.utils.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class BaseTest {

    protected static AndroidDriver driver;
    protected Calculator calculator = new Calculator(driver);

    @BeforeAll
    public static void setUp() {
        driver = Driver.getDriver();
        setAllureEnvironment();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }

    static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Platform.Name", "Android")
                        .put("Platform.Version", "11.0")
                        .build());
    }
}