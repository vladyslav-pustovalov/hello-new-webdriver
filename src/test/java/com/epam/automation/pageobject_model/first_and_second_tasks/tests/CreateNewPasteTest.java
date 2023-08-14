package com.epam.automation.pageobject_model.first_and_second_tasks.tests;

import com.epam.automation.pageobject_model.first_and_second_tasks.pastebin_pages.PastebinCreatedPastePage;
import com.epam.automation.pageobject_model.first_and_second_tasks.pastebin_pages.PastebinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.time.Duration;

public class CreateNewPasteTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void iCanWinTest() {
        String stringToWrite = "Hello from WebDriver";
        String expirationTimeValue = "10M";
        String nameOrTitle = "helloweb";

        PastebinCreatedPastePage createdPage = new PastebinMainPage(driver)
                .openPage()
                .writeCodeIntoCodeField(stringToWrite)
                .selectPasteExpiration(expirationTimeValue)
                .writePasteNameTitle(nameOrTitle)
                .createNewPaste();
    }

    @Test
    public void bringItOnTest() {
        // TODO: 07/08/2023 raad and check how it works
        /*language=bash*/
        String stringToWrite = """
                               git config --global user.name  "New Sheriff in Town"
                               git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                               git push origin master --force
                               """;
        String syntaxHighLightValue = "8";
        String syntaxTypeExpected = "Bash";
        String expirationTimeValue = "10M";
        String nameOrTitle = "how to gain dominance among developers";

        PastebinCreatedPastePage createdPage = new PastebinMainPage(driver)
                .openPage()
                .selectSyntaxHighlight(syntaxHighLightValue)
                .writeCodeIntoCodeField(stringToWrite)
                .selectPasteExpiration(expirationTimeValue)
                .writePasteNameTitle(nameOrTitle)
                .createNewPaste();

        //todo check that all works
        Assert.assertEquals(createdPage.getSyntaxLinkText(), syntaxTypeExpected);
        Assert.assertEquals(stringToWrite.replaceAll("\\s+",""), createdPage.getWrittenCode().replaceAll("\\s+",""));
        Assert.assertEquals(nameOrTitle, createdPage.getNameOrTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
