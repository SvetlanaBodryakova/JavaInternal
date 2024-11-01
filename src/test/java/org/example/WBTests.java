package org.example;

import jdk.jfr.Description;
import org.example.base.BaseTest;
import org.example.models.Card;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WBTests extends BaseTest {

    @Test
    @Description("Проверка названия и стоимости товаров в корзине")
    public void testProductNameAndPrice() {

        WebElement product1 = startingPage.selectProduct();
        WebElement product2 = startingPage.selectProduct();

        startingPage.viewProduct(product1);
        WebElement productCard1 = productForm.getProductCard();
        Card card1 = productForm.addToBasket(productCard1);
        productForm.closeProductCard();
        startingPage.viewProduct(product2);
        WebElement productCard2 = productForm.getProductCard();
        Card card2 = productForm.addToBasket(productCard2);
        productForm.closeProductCard();

        startingPage.goToBasketPage();

        WebElement item1 = basketPage.getItem(card1);
        WebElement item2 = basketPage.getItem(card2);
        double totalPrice = card1.getPrice() + card2.getPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(basketPage.getProductName(item1), card1.getName(), "Название товара не соответствует выбранному!");
        softAssert.assertEquals(basketPage.getPrice(item1), card1.getPrice(), "Цена не соответствует!");
        softAssert.assertEquals(basketPage.getProductName(item2), card2.getName(), "Название товара не соответствует выбранному!");
        softAssert.assertEquals(basketPage.getPrice(item2), card2.getPrice(), "Цена не соответствует!");
        softAssert.assertEquals(basketPage.getTotalPrice(), totalPrice, "Неверная общая сумма товаров");
        softAssert.assertEquals(basketPage.getNumberOfProducts(), 2, "Неверное количество товаров в корзине!");
        softAssert.assertAll();
    }
}