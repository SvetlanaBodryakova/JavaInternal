package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class='pay']//h2")
    private WebElement paymentBlockTitle;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> logos;

    @FindBy(xpath = "//section[@class='pay']//a")
    private WebElement aboutServiceLink;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement serviceTypeDropDown;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement inputPhoneField;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement inputAmountField;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement inputEmailField;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    private WebElement continueButton;

    public String getPaymentBlockTitle() {
        return paymentBlockTitle.getText().replace("\n", " ");
    }

    public boolean getLogos() {
        for (WebElement logo : logos) {
            if (!logo.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getLogoNames() {
        List<String> logoNames = new ArrayList<>();
        for (WebElement logo : logos) {
            logoNames.add(logo.getAttribute("alt"));
        }
        return logoNames;
    }

    public void followTheLink() {
        clickElement(aboutServiceLink);
    }

    public String selectPayOption() {
        return serviceTypeDropDown.getText();
    }

    public void enterPhone(String phoneNumber) {
        clickElement(inputPhoneField)
                .sendKeysToElement(inputPhoneField, phoneNumber);
    }

    public void enterAmount(String amount) {
        clickElement(inputAmountField)
                .sendKeysToElement(inputAmountField, amount);
    }

    public void enterEmail(String email) {
        clickElement(inputEmailField)
                .sendKeysToElement(inputEmailField, email);
    }

    public void clickContinueButton() {
        clickElement(continueButton);
    }
}