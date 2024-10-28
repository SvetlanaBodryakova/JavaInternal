package org.example;

import org.example.base.BaseTest;
import org.example.models.Card;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WBTests extends BaseTest {

    @Test
    public void testWB() {
        WebElement product1 = startingPage.selectProductCard();
        WebElement product2 = startingPage.selectProductCard();
        Card card1 = startingPage.addToBasket(product1);
        Card card2 = startingPage.addToBasket(product2);

        startingPage.goToBasketPage();


    }


}
