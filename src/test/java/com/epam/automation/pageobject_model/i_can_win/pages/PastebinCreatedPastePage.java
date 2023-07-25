package com.epam.automation.pageobject_model.i_can_win.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinCreatedPastePage extends AbstractPage {
    @FindBy(xpath = "//div[@class=\"info-top\"]/h1")
    private WebElement nameOrTitle;
    @FindBy(xpath = "//div[@title=\"When this paste gets automatically deleted\"]")
    private WebElement pasteExpirationTime;
    @FindBy(xpath = "//ol[@class=\"text\"]/li[@class=\"li1\"]/div")
    private WebElement writtenCode;

    public PastebinCreatedPastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    protected PastebinCreatedPastePage openPage() {
        return this;
    }

    public String getNameOrTitle() {
        return nameOrTitle.getText();
    }

    public String getWrittenCode() {
        return writtenCode.getText();
    }

    public String getExpirationTime() {
        return pasteExpirationTime.getText();
    }

    public boolean isNameOrTitlePresents() {
        return nameOrTitle.isDisplayed();
    }

    public boolean isExpirationTimePresents() {
        return pasteExpirationTime.isDisplayed();
    }

    public boolean isWrittenCodePresents() {
        return writtenCode.isDisplayed();
    }
}
