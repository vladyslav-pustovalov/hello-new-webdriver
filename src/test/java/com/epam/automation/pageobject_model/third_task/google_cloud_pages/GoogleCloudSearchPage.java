package com.epam.automation.pageobject_model.third_task.google_cloud_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchPage extends AbstractPage {

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']/b")
    private WebElement pricingCalculatorPageLink;

    public GoogleCloudSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected GoogleCloudSearchPage openPage() {
        return this;
    }

    public GoogleCloudPricingCalculatorPage openPricingCalculatorPage() {
        pricingCalculatorPageLink.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
