package com.epam.automation.pageobject_model.first_and_second_tasks.pastebin_pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PastebinMainPage extends AbstractPage {
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private static final String MAIN_PAGE_URL = "https://pastebin.com/";
    @FindBy(id = "postform-text")
    private WebElement codeInputField;
    @FindBy(id="postform-format")
    private WebElement syntaxHighlightSelect;
    @FindBy(id = "postform-expiration")
    private WebElement pasteExpirationSelect;
    @FindBy(id = "postform-name")
    private WebElement pasteNameTitleInputField;
    @FindBy(xpath = "//button[@class=\"btn -big\"][@type=\"submit\"]")
    private WebElement createNewPasteButton;


    public PastebinMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PastebinMainPage openPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public PastebinMainPage writeCodeIntoCodeField(String stringToWrite) {
        codeInputField.sendKeys(stringToWrite);
        return this;
    }

    public PastebinMainPage selectSyntaxHighlight(String value) {
        js.executeScript("arguments[0].style.visibility='visible';", syntaxHighlightSelect);
        Select drop = new Select(syntaxHighlightSelect);
        drop.selectByValue(value);
        return this;
    }

    public PastebinMainPage selectPasteExpiration(String value) {
        js.executeScript("arguments[0].style.visibility='visible';", pasteExpirationSelect);
        Select drop = new Select(pasteExpirationSelect);
        drop.selectByValue(value);
        return this;
    }

    public PastebinMainPage writePasteNameTitle(String nameOrTitle) {
        pasteNameTitleInputField.sendKeys(nameOrTitle);
        return this;
    }

    public PastebinCreatedPastePage createNewPaste() {
        createNewPasteButton.click();
        return new PastebinCreatedPastePage(driver);
    }
}
