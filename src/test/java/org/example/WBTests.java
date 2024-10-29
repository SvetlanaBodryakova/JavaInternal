package org.example;

import org.example.base.BaseTest;
import org.example.models.Card;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class WBTests extends BaseTest {

    @Test
    public void testWB() {

        List<WebElement> productCards = startingPage.getProductCards();
        WebElement productCard1 = startingPage.selectProductCard();
        WebElement productCard2 = startingPage.selectProductCard();
        Card card1 = startingPage.addToBasket(productCard1);
        Card card2 = startingPage.addToBasket(productCard2);

        startingPage.goToBasketPage();

        SoftAssert softAssert = new SoftAssert();
        WebElement item1 = basketPage.getItemInBasket(card1);
        WebElement item2 = basketPage.getItemInBasket(card2);
        double totalPrice = basketPage.getTotalPrice();
        int numberOfProducts = basketPage.getNumberOfProducts();

        softAssert.assertEquals(card1.getProductName(), basketPage.getProductName(item1), "Название товара не соответствует выбранному!");
        softAssert.assertEquals(card1.getPrice(), basketPage.getPrice(item1), "Цена не соответствует!");
        softAssert.assertEquals(card2.getProductName(), basketPage.getProductName(item2), "Название товара не соответствует выбранному!");
        softAssert.assertEquals(card2.getPrice(), basketPage.getPrice(item2), "Цена не соответствует!");
        softAssert.assertEquals(totalPrice, card1.getPrice()+ card2.getPrice(), "Невеоная общая сумма товаров");
        softAssert.assertEquals(numberOfProducts, basketPage.getNumberOfProducts(), "Неверное количество товаров в корзине!");
    }
}