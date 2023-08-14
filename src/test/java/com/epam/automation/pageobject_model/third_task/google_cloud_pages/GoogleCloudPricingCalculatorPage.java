package com.epam.automation.pageobject_model.third_task.google_cloud_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {
    private final String pricingCalculatorPageURL = "https://cloud.google.com/products/calculator";
    @FindBy(xpath = "//span[text()='Compute Engine']")
    private WebElement computeEngineBlock;
    @FindBy(id = "input_98")
    private WebElement numberOfInstances;
    @FindBy(id = "select_111")
    private WebElement operatingSystemSoftware;
    @FindBy(id = "select_115")
    private WebElement vMClass;
    @FindBy(id = "select_value_label_93")
    private WebElement machineSeries;
    @FindBy(id = "select_125")
    private WebElement instanceType;
    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUCheckbox;
    @FindBy(id = "select_490")
    private WebElement typeGPU;
    @FindBy(id = "select_492")
    private WebElement numberOfGPUs;
    @FindBy(id = "select_value_label_448")
    private WebElement localSSD;
    @FindBy(id = "select_value_label_96")
    private WebElement datacenterLocation;
    @FindBy(css = "#select_value_label_97")
    private WebElement commitedUsage;
    @FindBy(css = "#mainForm > div:nth-child(3) > div > md-card > md-card-content > div > div:nth-child(1) > form > div.layout-align-end-start.layout-row > button")
    private WebElement addToEstimate;
    @FindBy(css = "#compute > md-list > md-list-item:nth-child(8) > div.md-list-item-text.ng-binding")
    private WebElement resultVMClass;
    @FindBy(css = "#compute > md-list > md-list-item:nth-child(10) > div.md-list-item-text.ng-binding.cpc-cart-multiline.flex")
    private WebElement resultInstanceType;
    @FindBy(css = "#compute > md-list > md-list-item:nth-child(2) > div.md-list-item-text.ng-binding")
    private WebElement resultRegion;
    @FindBy(css = "#compute > md-list > md-list-item:nth-child(14) > div.md-list-item-text.ng-binding.cpc-cart-multiline.flex")
    private WebElement resultLocalSSD;
    @FindBy(css = "#compute > md-list > md-list-item:nth-child(6) > div.md-list-item-text.ng-binding")
    private WebElement resultCommitmentTerm;
    @FindBy(css = "#resultBlock > md-card > md-card-content > div > div > div > div.cpc-cart-total > h2 > b")
    private WebElement resultCost;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleCloudPricingCalculatorPage openPage() throws InterruptedException {
        driver.get(pricingCalculatorPageURL);
        addOneSecWait();
        return this;
    }

    private void switchToMyFrame() {
        driver.switchTo().frame(driver.findElement(By.xpath("//article[@id='cloud-site']//iframe")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        addOneSecWait();
    }

    public GoogleCloudPricingCalculatorPage openComputerEngineBlock() {
        switchToMyFrame();
        computeEngineBlock.click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setNumbersOfInstances(Integer sum) {
        numberOfInstances.sendKeys(sum.toString());
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setOperatingSystemSoftware(String value) {
        operatingSystemSoftware.click();
        driver.findElement(By.xpath("//*[@value='" + value + "']")).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setVMClass(String value) {
        vMClass.click();
        driver.findElement(By.xpath("//*[@value='" + value + "']")).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setMachineSeries(String value) {
        machineSeries.click();
        driver.findElement(By.cssSelector(value)).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setInstanceType(String value) throws InterruptedException {
        instanceType.click();
        addOneSecWait();
        driver.findElement(By.cssSelector(value)).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addGPU() throws InterruptedException {
        addGPUCheckbox.click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setGPUType(String value) {
        typeGPU.click();
        addOneSecWait();
        driver.findElement(By.xpath("//*[@value='" + value + "']")).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setNumbersOfGPUs(String value) {
        numberOfGPUs.click();
        addOneSecWait();
        driver.findElement(By.xpath("//*[@id='select_container_493']/md-select-menu/md-content/md-option[@value='" + value + "']")).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setLocalSSD(String value) {
        localSSD.click();
        addOneSecWait();
        driver.findElement(By.xpath("//*[@id='select_container_450']/md-select-menu/md-content/md-option[@value='" + value + "']")).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setDatacenterLocation(String value) {
        datacenterLocation.click();
        addOneSecWait();
        driver.findElement(By.xpath("//*[@id='select_container_132']/md-select-menu/md-content/md-optgroup/md-option[@value='" + value + "']")).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setCommitedUsage(String value) {
        commitedUsage.click();
        addOneSecWait();
        driver.findElement(By.cssSelector(value)).click();
        addOneSecWait();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        addToEstimate.click();
        addOneSecWait();
        return this;
    }

    private String remove(String input) {
        return input
                .substring(input.indexOf(":") + 1).trim()
                .replaceAll("\n", "")
                .replaceAll("Committed.*", "");
    }

    public String getResultVMClass() {
        return remove(resultVMClass.getText());
    }

    public String getResultInstanceType() {
        return remove(resultInstanceType.getText());
    }

    public String getResultRegion() {
        return remove(resultRegion.getText());
    }

    public String getResultLocalSSD() {
        return remove(resultLocalSSD.getText());
    }

    public String getResultCommitmentTerm() {
        return remove(resultCommitmentTerm.getText());
    }

    public String getResultCost() {
        return remove(resultCost.getText());
    }
}
