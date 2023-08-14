package com.epam.automation.pageobject_model.first_and_second_tasks.pastebin_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class PastebinCreatedPastePage extends AbstractPage {
    @FindBy(xpath = "//div[@class=\"info-top\"]/h1")
    private WebElement nameOrTitle;
    @FindBy(xpath = "//div[@title=\"When this paste gets automatically deleted\"]")
    private WebElement pasteExpirationTime;
    @FindBy(xpath = "//div[@class=\"left\"]/a[@class=\"btn -small h_800\"]")
    private WebElement pasteSyntaxLink;
    @FindBys(@FindBy(xpath = "//ol/li[@class=\"li1\"]/div"))
    private List<WebElement> writtenCode;

    public PastebinCreatedPastePage(WebDriver driver) {
        super(driver);
    }

    protected PastebinCreatedPastePage openPage() {
        return this;
    }

    public String getNameOrTitle() {
        return nameOrTitle.getText();
    }

    public String getSyntaxLinkText() {
        return pasteSyntaxLink.getText();
    }

    public String getWrittenCode() {
        List<String> textOfCodes = writtenCode.stream().map(WebElement::getText).toList();
        String result = textOfCodes.get(0);
        for (int i = 1; i<textOfCodes.size(); i++) {
            result = result + " " + textOfCodes.get(i);
        }

        return result;
    }
}
