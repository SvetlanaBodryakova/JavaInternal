package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoPage extends BasePage {

    public InfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container-fluid']//h3")
    private WebElement articleTitle;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getArticleTitle() {
        return articleTitle.getText();
    }
}
