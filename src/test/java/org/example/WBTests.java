package org.example;

import org.example.base.BaseTest;
import org.example.models.Card;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WBTests extends BaseTest {

    @Test
    public void testWB() {

        WebElement product1 = startingPage.selectProduct();
        WebElement product2 = startingPage.selectProduct();

        startingPage.viewProduct(product1);
        WebElement productCard1 = productForm.getProductCard();
        Card card1 = productForm.addToBasket(productCard1);
        productForm.closePopup();

        startingPage.viewProduct(product2);
        WebElement productCard2 = productForm.getProductCard();
        Card card2 = productForm.addToBasket(productCard2);
        productForm.closePopup();

        System.out.println(card1.toString());
        System.out.println(card2.toString());

        startingPage.goToBasketPage();

        WebElement item1 = basketPage.getItem(card1);
        WebElement item2 = basketPage.getItem(card2);
        double totalPrice = productForm.getProductPrice(productCard1) + productForm.getProductPrice(productCard2);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(basketPage.getProductName(item1), card1.getProductName(), "Название товара не соответствует выбранному!");
        softAssert.assertEquals(basketPage.getPrice(item1), card1.getPrice(), "Цена не соответствует!");
        softAssert.assertEquals(basketPage.getProductName(item2), card2.getProductName(), "Название товара не соответствует выбранному!");
        softAssert.assertEquals(basketPage.getPrice(item2), card2.getPrice(), "Цена не соответствует!");
        softAssert.assertEquals(totalPrice, card1.getPrice() + card2.getPrice(), "Неверная общая сумма товаров");
        softAssert.assertEquals(basketPage.getNumberOfProducts(), 2, "Неверное количество товаров в корзине!");
        softAssert.assertAll();
    }
}