package org.example.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    @FindBy(xpath = "//button[@class='btn btn_gray cookie__cancel']")
    private WebElement cookies;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BasePage clickElement(WebElement webElement) {
        webElement.click();
        return this;
    }

    public BasePage sendKeysToElement(WebElement webElement, String text) {
        webElement.sendKeys(text);
        return this;
    }

    public void clickCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(cookies)).click();
    }
}