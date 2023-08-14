package com.epam.automation.pageobject_model.course.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleSearchResultPage extends AbstractPage {
    private final String SEARCH_PAGE_BASE_URL = "https://www.google.com/search?q=";
    private String term;
    @FindBy(xpath = "//h3")
    List<WebElement> searchLinksHeaders;

    public GoogleSearchResultPage(WebDriver driver, String term) {
        super(driver);
        this.term = term;
        PageFactory.initElements(driver, this);
    }


    private List<String> splitSearchTermIntoWords(String term) {
        List<String> splited = new ArrayList<>();
        if (term != null) {
            splited = Arrays.stream(term.split(" ")).toList();
        } else {
            System.out.println("WARN: You can not search without any term!");
        }
        return splited;
    }

    @Override
    public GoogleSearchResultPage openPage() {
        String searchPageURLEndpoint = splitSearchTermIntoWords(term).get(0);
        for (int i = 1; i < splitSearchTermIntoWords(term).size(); i++) {
            searchPageURLEndpoint = searchPageURLEndpoint + "+" + splitSearchTermIntoWords(term).get(i);
        }
        driver.get(SEARCH_PAGE_BASE_URL + searchPageURLEndpoint);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@role='heading']")));
        return this;
    }

    public int countNumberOfSearchHeaders() {
        System.out.println("There are " + searchLinksHeaders.size() + " searched links");
        return searchLinksHeaders.size();
    }
}
