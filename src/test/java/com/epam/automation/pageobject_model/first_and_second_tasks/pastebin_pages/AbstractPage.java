package com.epam.automation.pageobject_model.first_and_second_tasks.pastebin_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    public Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        Wait<WebDriver> wait1 = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    protected abstract AbstractPage openPage();
}
