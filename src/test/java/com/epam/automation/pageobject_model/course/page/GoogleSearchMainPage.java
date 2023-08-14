package com.epam.automation.pageobject_model.course.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchMainPage extends AbstractPage {
    private static final String MAIN_PAGE_URL = "https://www.google.com/";
    @FindBy(xpath = "//div/textarea[@type=\"search\"]")
    private WebElement searchInputField;

    public GoogleSearchMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleSearchMainPage openPage() {
        driver.get(MAIN_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//img[@alt=\"Google\"]")));
        return this;
    }

    public GoogleSearchResultPage searchForTerms(String term) {
        searchInputField.sendKeys(term);
        searchInputField.submit();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@role='heading']")));
        return new GoogleSearchResultPage(driver, term);
    }
}
