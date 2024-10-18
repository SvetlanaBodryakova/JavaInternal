package org.example;

import org.example.base.BaseTest;
import org.example.enums.PaymentOptions;
import org.example.pages.MainPage;
import org.example.pages.forms.PaidForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsTests extends BaseTest {

    private MainPage mainPage;
    private PaidForm paidForm;

    @BeforeAll
    public void setPage() {
        mainPage = new MainPage(driver);
        paidForm = new PaidForm(driver);
    }

    @ParameterizedTest
    @EnumSource(PaymentOptions.class)
    @DisplayName("Проверка плейсхолдеров в полях каждого варианта оплаты услуг")
    public void testPlaceholders(PaymentOptions paymentOption) {
        String payOptionTitle = mainPage.selectPayOption(paymentOption).getText();

        assertAll("Проверка плейсхолдеров и их названий",
                () -> assertEquals(paymentOption.title, payOptionTitle, "Неверный вид оплаты!"),
                () -> assertEquals(expectedPhoneFieldPlaceholder(paymentOption), mainPage.getPhoneFieldPlaceholder(paymentOption),
                        "Неверный плейсхолдер в поле ввода номера телефона"),
                () -> assertEquals("Сумма", mainPage.getAmountFieldPlaceholder(paymentOption),
                        "Неверный плейсхолдер в поле ввода суммы"),
                () -> assertEquals("E-mail для отправки чека", mainPage.getEmailFieldPlaceholder(paymentOption),
                        "Неверный плейсхолдер в поле ввода email")
        );
    }

    @Test
    @DisplayName("Проверка формы оплаты")
    public void testPaidForm() {
        String phoneNumber = "297777777";
        double amount = 5;
        String email = "test@test.com";
        String cardNumberPlaceholder = "Номер карты";
        String expDatePlaceholder = "Срок действия";
        String cvcPlaceholder = "CVC";
        String cardHolderPlaceholder = "Имя держателя (как на карте)";

        mainPage.selectPayOption(PaymentOptions.COMMUNICATION);
        mainPage.enterPhone(phoneNumber);
        mainPage.enterAmount(amount);
        mainPage.enterEmail(email);
        mainPage.clickContinueButton();
        paidForm.switchToFrame();

        assertAll("Проверка формы оплаты",
                () -> assertTrue(paidForm.getCardInputForm().isDisplayed(), "Форма оплаты не видна!"),
                () -> assertTrue(paidForm.getPhoneNumber().contains(phoneNumber), "Не соответствует номер!"),
                () -> assertEquals(amount, paidForm.getAmount(), "Неверная сумма!"),
                () -> assertEquals(amount, paidForm.getButtonInfo(), "Неверная сумма!"),
                () -> assertTrue(paidForm.getLogos(), "Логотип не отображается!"),
                () -> assertEquals(cardNumberPlaceholder, paidForm.getCardNumberFieldPlaceholder(),
                        "Неверный плейсхолдер в поле ввода номера карты"),
                () -> assertEquals(expDatePlaceholder, paidForm.getExpDateFieldPlaceholder(),
                        "Неверный плейсхолдер в поле ввода срока действия карты"),
                () -> assertEquals(cvcPlaceholder, paidForm.getCvcFieldPlaceholder(),
                        "Неверный плейсхолдер в поле ввода кода"),
                () -> assertEquals(cardHolderPlaceholder, paidForm.getCardHolderNameFieldPlaceholder(),
                        "Неверный плейсхолдер в поле ввода владельца карты")
        );
    }

    public String expectedPhoneFieldPlaceholder(PaymentOptions paymentOption) {
        String expectedPhoneFieldPlaceholder;
        switch (paymentOption) {
            case HOMEINTERNET:
                expectedPhoneFieldPlaceholder = "Номер абонента";
                break;
            case INSTALLMENT:
                expectedPhoneFieldPlaceholder = "Номер счета на 44";
                break;
            case DEBT:
                expectedPhoneFieldPlaceholder = "Номер счета на 2073";
                break;
            default:
                expectedPhoneFieldPlaceholder = "Номер телефона";
        }
        return expectedPhoneFieldPlaceholder;
    }
}