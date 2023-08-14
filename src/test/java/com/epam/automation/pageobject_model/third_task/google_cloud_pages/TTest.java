//// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//import java.util.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//public class TTest {
//  private WebDriver driver;
//  private Map<String, Object> vars;
//  JavascriptExecutor js;
//  @Before
//  public void setUp() {
//    driver = new ChromeDriver();
//    js = (JavascriptExecutor) driver;
//    vars = new HashMap<String, Object>();
//  }
//  @After
//  public void tearDown() {
//    driver.quit();
//  }
//  @Test
//  public void t() {
//    driver.get("https://cloud.google.com/products/calculator");
//    driver.manage().window().setSize(new Dimension(1920, 1080));
//    driver.switchTo().frame(0);
//    driver.switchTo().frame(0);
//    driver.findElement(By.cssSelector("#tab-item-1 .hexagon-in2")).click();
//    driver.findElement(By.id("input_98")).click();
//    driver.findElement(By.id("input_98")).sendKeys("4");
//    driver.findElement(By.cssSelector("#select_value_label_90 .md-text")).click();
//    driver.findElement(By.cssSelector("#select_option_100 > .md-text")).click();
//    driver.findElement(By.cssSelector("#select_value_label_91 > span:nth-child(1)")).click();
//    driver.findElement(By.id("select_option_113")).click();
//    driver.findElement(By.cssSelector("#select_value_label_93 > span:nth-child(1)")).click();
//    driver.findElement(By.id("select_option_214")).click();
//    driver.findElement(By.cssSelector("#select_value_label_94 .md-text")).click();
//    driver.findElement(By.cssSelector("#select_option_454 > .md-text")).click();
//    driver.findElement(By.cssSelector(".layout-row:nth-child(15) .md-label")).click();
//    driver.findElement(By.id("select_490")).click();
//    driver.findElement(By.id("select_option_497")).click();
//    driver.findElement(By.id("select_value_label_489")).click();
//    driver.findElement(By.id("select_option_496")).click();
//    driver.findElement(By.cssSelector(".ng-scope:nth-child(17) > .layout-column")).click();
//    driver.findElement(By.cssSelector("#select_value_label_448 > span:nth-child(1)")).click();
//    driver.findElement(By.id("select_option_475")).click();
//    driver.findElement(By.cssSelector("#select_value_label_96 > span:nth-child(1)")).click();
//    driver.findElement(By.id("select_option_256")).click();
//  }
//}