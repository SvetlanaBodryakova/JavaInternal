package org.example.pages;

import org.example.enums.PaymentOptions;
import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement payOptionDropDown;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    private WebElement continueButton;

    private By getPhoneFieldLocator(PaymentOptions paymentOption) {
        if (paymentOption.title.equals("Услуги связи") || paymentOption.title.equals("Домашний интернет")) {
            return By.xpath(String.format("//form//input[@id='%s-phone']", paymentOption.attribute));
        }
        if (paymentOption.title.equals("Рассрочка") || paymentOption.title.equals("Задолженность")) {
            return By.xpath(String.format("//form//input[@id='score-%s']", paymentOption.attribute));
        }
        return null;
    }

    private By getAmountFieldLocator(PaymentOptions paymentOption) {
        return By.xpath(String.format("//form//input[@id='%s-sum']", paymentOption.attribute));
    }

    private By getEmailFieldLocator(PaymentOptions paymentOption) {
        return By.xpath(String.format("//form//input[@id='%s-email']", paymentOption.attribute));
    }

    public WebElement selectPayOption(PaymentOptions paymentOption) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payOptionDropDown);
        clickElement(payOptionDropDown);
        WebElement payOption = driver.findElement(paymentOption.locator);
        payOption.click();
        return payOption;
    }

    public String getPhoneFieldPlaceholder(PaymentOptions paymentOption) {
        return driver.findElement(getPhoneFieldLocator(paymentOption)).getAttribute("placeholder");
    }

    public String getAmountFieldPlaceholder(PaymentOptions paymentOption) {
        return driver.findElement(getAmountFieldLocator(paymentOption)).getAttribute("placeholder");
    }

    public String getEmailFieldPlaceholder(PaymentOptions paymentOption) {
        return driver.findElement(getEmailFieldLocator(paymentOption)).getAttribute("placeholder");
    }

    public void enterPhone(String phoneNumber) {
        driver.findElement(getPhoneFieldLocator(PaymentOptions.COMMUNICATION))
                .sendKeys(phoneNumber);
    }

    public void enterAmount(double amount) {
        driver.findElement(getAmountFieldLocator(PaymentOptions.COMMUNICATION))
                .sendKeys(Double.toString(amount));
    }

    public void enterEmail(String email) {
        driver.findElement(getEmailFieldLocator(PaymentOptions.COMMUNICATION))
                .sendKeys(email);
    }

    public void clickContinueButton() {
        clickElement(continueButton);
    }
}