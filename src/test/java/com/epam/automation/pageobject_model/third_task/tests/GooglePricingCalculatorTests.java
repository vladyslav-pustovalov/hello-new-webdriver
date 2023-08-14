package com.epam.automation.pageobject_model.third_task.tests;

import com.epam.automation.pageobject_model.third_task.google_cloud_pages.GoogleCloudMainPage;
import com.epam.automation.pageobject_model.third_task.google_cloud_pages.GoogleCloudPricingCalculatorPage;
import com.epam.automation.pageobject_model.third_task.google_cloud_pages.GoogleCloudSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GooglePricingCalculatorTests {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void hurtMePlentyTest() throws InterruptedException {
        String textToSearch = "Google Cloud Platform Pricing Calculator";
        String operatingSystemSoftwareValue = "free";
        String vMClassValue = "regular";
        String machineSeriesSelector = "#select_option_214";
        String instanceTypeSelector = "#select_option_454";
        String gPUTypeValue = "NVIDIA_TESLA_V100";
        String numberOfGPUsValue = "1";
        String numberOfLocalSSDsValue = "2";
        String datacenterLocationValue = "europe-west3";
        String commitedUsageSelector = "#select_option_136";

        GoogleCloudMainPage mainPage = new GoogleCloudMainPage(driver)
                .openPage();

        GoogleCloudSearchPage searchPage = mainPage
                .openSearchField()
                .textIntoSearchField(textToSearch)
                .startSearch();

        GoogleCloudPricingCalculatorPage pricingCalculatorPage = searchPage
                .openPricingCalculatorPage()
                .openComputerEngineBlock()
                .setNumbersOfInstances(4)
                .setOperatingSystemSoftware(operatingSystemSoftwareValue)
                .setVMClass(vMClassValue)
                .setMachineSeries(machineSeriesSelector)
                .setInstanceType(instanceTypeSelector)
                .addGPU()
                .setGPUType(gPUTypeValue)
                .setNumbersOfGPUs(numberOfGPUsValue)
                .setLocalSSD(numberOfLocalSSDsValue)
                .setDatacenterLocation(datacenterLocationValue)
                .setCommitedUsage(commitedUsageSelector)
                .addToEstimate();

        Assert.assertEquals(pricingCalculatorPage.getResultVMClass(), "Regular");
        Assert.assertEquals(pricingCalculatorPage.getResultInstanceType(), "n1-standard-8");
        Assert.assertEquals(pricingCalculatorPage.getResultRegion(), "Frankfurt");
        Assert.assertEquals(pricingCalculatorPage.getResultLocalSSD(), "2x375 GiB");
        Assert.assertEquals(pricingCalculatorPage.getResultCommitmentTerm(), "1 Year");
        Assert.assertEquals(pricingCalculatorPage.getResultCost(), "USD 1,081.20 per 1 month");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
//        driver.quit();
//        driver = null;
    }
}
