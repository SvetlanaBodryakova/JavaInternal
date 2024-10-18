package org.example.pages.forms;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaidForm extends BasePage {

    public PaidForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "iframe[class='bepaid-iframe']")
    private WebElement paidForm;

    @FindBy(css = "app-card-input > form")
    private WebElement cardInputForm;

    @FindBy(css = "[class*='pay-description__cost']>span:first-child")
    private WebElement headerAmount;

    @FindBy(css = "[class*='pay-description__text']")
    private WebElement headerInfo;

    @FindBy(css = "[class*='card-page__card'] button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "[class*='cards-brands'] img")
    private List<WebElement> logos;

    @FindBy(css = "input[id='cc-number']+label")
    private WebElement cardNumber;

    @FindBy(css = "div[class*='expires-input'] label")
    private WebElement expDate;

    @FindBy(css = "input[name='verification_value'] + label")
    private WebElement cvc;

    @FindBy(css = "input[formcontrolname='holder'] + label")
    private WebElement cardHolderName;

    public WebElement getCardInputForm() {
        return (new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-card-input > form"))));
    }

    public void switchToFrame() {
        driver.switchTo().frame(paidForm);
    }

    public String getPhoneNumber() {
        return headerInfo.getText();
    }

    public double getAmount() {
        return Double.parseDouble(headerAmount
                .getText().replaceAll("[^0-9.]", ""));
    }

    public double getButtonInfo() {
        return Double.parseDouble(submitButton
                .getText().replaceAll("[^0-9.]", ""));
    }

    public String getCardNumberFieldPlaceholder() {
        return cardNumber.getText();
    }

    public String getExpDateFieldPlaceholder() {
        return expDate.getText();
    }

    public String getCvcFieldPlaceholder() {
        return cvc.getText();
    }

    public String getCardHolderNameFieldPlaceholder() {
        return cardHolderName.getText();
    }

    public boolean getLogos() {
        for (WebElement logo : logos) {
            new WebDriverWait(driver, Duration.ofSeconds(4))
                    .until(ExpectedConditions.visibilityOf(logo));
            if (!logo.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}