package org.example;

import org.example.base.BaseTest;
import org.example.pages.InfoPage;
import org.example.pages.MainPage;
import org.example.pages.forms.PaidForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsTests extends BaseTest {

    private MainPage mainPage;
    private InfoPage infoPage;
    private PaidForm paidForm;

    @BeforeAll
    public void setPage() {
        mainPage = new MainPage(driver);
        infoPage = new InfoPage(driver);
        paidForm = new PaidForm(driver);
    }

    @Test
    @DisplayName("Проверка названия блока онлайн оплаты")
    public void testPaymentBlockTitle() {
        String title = "Онлайн пополнение без комиссии";

        assertEquals(title, mainPage.getPaymentBlockTitle(), "Неверное название блока оплаты!");
    }

    @Test
    @DisplayName("Проверка логотипов")
    public void testLogos() {
        List<String> logoNames = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        assertAll("Проверка наличия логотипов и их названий",
                () -> assertTrue(mainPage.getLogos(), "Логотипы не отображается!"),
                () -> assertTrue(mainPage.getLogoNames().containsAll(logoNames),
                        "Отображаются не все логотипы!")
        );
    }

    @Test
    @DisplayName("Проверка ссылки «Подробнее о сервисе»")
    public void testAboutServiceLink() {
        String pageTitle = "Порядок оплаты и безопасность интернет платежей";
        String articleTitle = "Оплата банковской картой";

        mainPage.followTheLink();

        assertAll("Проверка ссылки «Подробнее о сервисе»",
                () -> assertEquals(pageTitle, infoPage.getPageTitle(), "Неверное название страницы!"),
                () -> assertTrue(infoPage.getArticleTitle().contains(articleTitle))
        );
    }

    @Test
    @DisplayName("Проверка работы кнопки «Продолжить»")
    public void testPaidForm() {
        String payOption = "Услуги связи";

        assertEquals(payOption, mainPage.selectPayOption());

        mainPage.enterPhone("297777777");
        mainPage.enterAmount("5");
        mainPage.enterEmail("test@test.com");
        mainPage.clickContinueButton();
        paidForm.switchToFrame();

        assertTrue(paidForm.getCardInputForm().isDisplayed(), "Форма оплаты не видна!");
    }
}