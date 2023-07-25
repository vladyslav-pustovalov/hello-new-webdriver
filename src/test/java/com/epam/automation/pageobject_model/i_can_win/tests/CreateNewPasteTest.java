package com.epam.automation.pageobject_model.i_can_win.tests;

import com.epam.automation.pageobject_model.i_can_win.pages.PastebinCreatedPastePage;
import com.epam.automation.pageobject_model.i_can_win.pages.PastebinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void creatingNewPasteTest() {
        String stringToWrite = "Hello from WebDriver";
        String expirationTimeValue = "10M";
        String nameOrTitle = "helloweb";

        PastebinMainPage newPaste = new PastebinMainPage(driver)
                .openPage();

        Assert.assertTrue(newPaste.isCodeInputFieldPresents());
        Assert.assertTrue(newPaste.isNameOrTitleFieldPresents());
        Assert.assertTrue(newPaste.isCreateButtonPresents());

        PastebinCreatedPastePage createdPage = newPaste
                .writeCodeIntoCodeField(stringToWrite)
                .selectPasteExpiration(expirationTimeValue)
                .writePasteNameTitle(nameOrTitle)
                .createNewPaste();

        Assert.assertTrue(createdPage.isNameOrTitlePresents());
        Assert.assertTrue(createdPage.isExpirationTimePresents());
        Assert.assertTrue(createdPage.isWrittenCodePresents());

        Assert.assertEquals(stringToWrite, createdPage.getWrittenCode());
        Assert.assertEquals(nameOrTitle, createdPage.getNameOrTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
