package com.finexus.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavFDTest1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMavFDTest1() throws Exception {
    driver.get("https://freecrm.com/");
    driver.findElement(By.linkText("sign up")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("das@khatri.com");
    driver.findElement(By.id("phone_number")).click();
    driver.findElement(By.id("phone_number")).clear();
    driver.findElement(By.id("phone_number")).sendKeys("03452333456");
    driver.findElement(By.id("terms")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='reCAPTCHA'])[1]/preceding::div[8]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.name("action")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
