package org.example.pages.forms;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaidForm extends BasePage {

    public PaidForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement paidForm;

    @FindBy(xpath = "//app-card-input//form")
    private WebElement cardInputForm;

    public WebElement getCardInputForm() {
        return (new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card-input//form"))));
    }

    public void switchToFrame() {
        driver.switchTo().frame(paidForm);
    }
}
