package com.epam.automation.pageobject_model.third_task.google_cloud_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudMainPage extends AbstractPage {
    private final String mainPageURL = "https://cloud.google.com/ ";

    @FindBy(name = "q")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleCloudMainPage openPage() {
        driver.get(mainPageURL);
        return this;
    }

    public GoogleCloudMainPage openSearchField() {
        searchButton.click();
        return this;
    }

    public GoogleCloudMainPage textIntoSearchField(String textToSearch) {
        searchField.sendKeys(textToSearch);
        searchField.submit();
        return this;
    }

    public GoogleCloudSearchPage startSearch() {
        searchField.submit();
        return new GoogleCloudSearchPage(driver);
    }
}
