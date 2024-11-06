package org.example.pages.forms;

import org.example.models.Card;
import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ProductForm extends BasePage {

    public ProductForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='popup i-popup-same-part-kt j-product-popup shown']")
    private WebElement productCard;

    @FindBy(css = "[class='j-close popup__close close']")
    private WebElement closePopup;

    @FindBy(css = "[class*='product__brand-name']+span[data-link]")
    private WebElement productName;

    @FindBy(css = "[class*='final-price']")
    private WebElement price;

    @FindBy(css = "[class='order__button btn-main']")
    private WebElement basketButton;

    @FindBy(css = "[class*='popup popup-list-of-sizes shown slideUp']")
    private WebElement selectSizePopup;

    @FindBy(css = "[class='sizes-list j-quick-order-sizes'] >li")
    private List<WebElement> sizeButtons;

    public WebElement getProductCard() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='popup i-popup-same-part-kt j-product-popup shown']")));
        return productCard;
    }

    public Card addToBasket(WebElement element) {
        clickElement(basketButton);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='popup popup-list-of-sizes shown slideUp']")));
            selectSize();
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Окно выбора размера не отображается!");
        }
        return getCard(element);
    }

    private void selectSize() {
        Random random = new Random();
        clickElement(sizeButtons.get(random.nextInt(sizeButtons.size())));
    }

    public String getProductName(WebElement element) {
        return element.findElement(By.cssSelector("[class*='product__brand-name']+span[data-link]")).getText();
    }

    public Double getProductPrice(WebElement element) {
        return Double.parseDouble(element.findElement(By.cssSelector("[class*='final-price']"))
                .getText().replaceAll("[^0-9.]", ""));
    }

    private Card getCard(WebElement element) {
        String name = getProductName(element);
        double price = getProductPrice(element);
        return new Card(name, price);
    }

    public void closeProductCard() {
        clickElement(closePopup);
    }
}