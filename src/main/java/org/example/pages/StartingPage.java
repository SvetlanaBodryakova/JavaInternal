package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StartingPage extends BasePage {
    public StartingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class*='product-card__wrapper']")
    private List<WebElement> productCards;

    @FindBy(css = "[data-wba-header-name='Cart']")
    private WebElement basketIcon;

    @FindBy(css = "[class='product-card__fast-view hide-mobile j-open-product-popup']")
    private WebElement viewButton;

    private List<WebElement> getProductCards() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElements(productCards));
        return productCards;
    }

    public WebElement selectProduct() {
        List<WebElement> productCards = getProductCards();
        Random random = new Random();
        return productCards.get(random.nextInt(productCards.size()));
    }

    public void viewProduct(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        new Actions(driver)
                .moveToElement(element)
                .build()
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element
                        .findElement(By.cssSelector("[class='product-card__fast-view hide-mobile j-open-product-popup']"))))
                .click();
    }

    public void goToBasketPage() {
        clickElement(basketIcon);
    }
}