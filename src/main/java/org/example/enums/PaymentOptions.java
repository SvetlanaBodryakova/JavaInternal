package org.example.enums;

import org.openqa.selenium.By;

public enum PaymentOptions {
    COMMUNICATION("Услуги связи", "connection"),
    HOMEINTERNET("Домашний интернет", "internet"),
    INSTALLMENT("Рассрочка", "instalment"),
    DEBT("Задолженность", "arrears");

    public String title;
    public String attribute;
    public By locator;

    PaymentOptions(String title, String attribute) {
        this.title = title;
        this.attribute = attribute;
        this.locator = By.xpath(String.format("//p[@class='select__option'][text()='%s']", title));
    }
}
