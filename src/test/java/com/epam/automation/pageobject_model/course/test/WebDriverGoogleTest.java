package com.epam.automation.pageobject_model.course.test;

import com.epam.automation.pageobject_model.course.page.GoogleSearchMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverGoogleTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Just first test, JIRA ticket should be here")
    public void googleSearchResultsNotEmpty() {

        int expectedSearchLinksNumber = new GoogleSearchMainPage(driver)
                .openPage()
                .searchForTerms("Selenium Java")
                .countNumberOfSearchHeaders();

        Assert.assertTrue(expectedSearchLinksNumber > 0, "The searched list is empty!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
