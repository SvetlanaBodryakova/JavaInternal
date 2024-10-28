package org.example.pages;

import org.example.models.Card;
import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
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

    @FindBy(css = "[class='popup i-popup-same-part-kt j-product-popup shown']")
    private WebElement productPopup;

    @FindBy(css = "[class='j-close popup__close close']")
    private WebElement closePopup;

    @FindBy(css = "[class='product__brand-name'] + span")
    private WebElement productName;

    @FindBy(css = "[class='price-block__final-price wallet']")
    private WebElement price;

    @FindBy(css = "order__button btn-main")
    private WebElement basketButton;

    @FindBy(css = "[class*='popup popup-list-of-sizes shown slideUp']")
    private WebElement selectSizePopup;

    @FindBy(css = "[class='sizes-list j-quick-order-sizes'] >li")
    private List<WebElement> sizeButtons;

    public WebElement selectProductCard() {
        Random random = new Random();
        return productCards.get(random.nextInt(productCards.size()));
    }

    public Card addToBasket(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        new Actions(driver)
                .moveToElement(element)
                .build()
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(viewButton)).click();
        clickElement(basketButton);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='popup popup-list-of-sizes shown slideUp']")));
            selectSize();
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Окно выбора размера не отображается!");
        }
        clickElement(closePopup);
        return getCard(productPopup);
    }

    private void selectSize() {
        Random random = new Random();
        clickElement(sizeButtons.get(random.nextInt(sizeButtons.size())));
    }

    public String getProductName(WebElement element) {
        return productName.getText().replace("/ ", "");
    }

    private Double getProductPrice(WebElement element) {
        return Double.parseDouble(price.getText().replaceAll("[^0-9.]", ""));
    }

    private Card getCard(WebElement element) {
        String name = getProductName(element);
        double price = getProductPrice(element);
        return new Card(name, price);
    }

    public void goToBasketPage() {
        clickElement(basketIcon);
    }
}
