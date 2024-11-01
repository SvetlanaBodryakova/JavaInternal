package org.example.pages;

import org.example.models.Card;
import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='basket-form__basket-section basket-section']")
    private WebElement basketSection;

    @FindBy(css = "[class*='list-item__wrap']")
    private List<WebElement> items;

    @FindBy(css = "[class*='good-info__good-name']")
    private WebElement productName;

    @FindBy(css = "[class*='count__numeric']")
    private List<WebElement> quantity;

    @FindBy(css = "[class*='list-item__price-new']")
    private WebElement price;

    @FindBy(css = "[class*='top__total line'] span[data-link]")
    private WebElement totalPrice;


    private List<WebElement> getProductsInBasket() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(basketSection));
        return items;
    }

    public String getProductName(WebElement element) {
        return element.findElement(By.cssSelector("[class*='good-info__good-name']")).getText();
    }

    public double getPrice(WebElement element) {
        return Double.parseDouble(element.findElement(By.cssSelector("[class*='list-item__price-new']"))
                .getText().replaceAll("[^0-9.]", ""));
    }

    public double getTotalPrice() {
        return Double.parseDouble(totalPrice.getText().replaceAll("[^0-9.]", ""));
    }

    public int getNumberOfProducts() {
        return quantity.stream()
                .mapToInt(n -> Integer.parseInt(n.getAttribute("value")))
                .sum();
    }

    public WebElement getItem(Card card) {
        return getProductsInBasket().stream()
                .filter(webElement -> getProductName(webElement).contains(card.getName()))
                .findFirst()
                .get();
    }
}