package com.finexus.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CoderaTC {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCoderaTC() throws Exception {
    driver.get("http://madebycodera.com/who-we-are");
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Who We Are")).click();
    driver.findElement(By.linkText("Tech")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rust'])[1]/following::img[1]")).click();
    driver.findElement(By.linkText("Contact")).click();
    driver.findElement(By.id("Name-2")).click();
    driver.findElement(By.id("Name-2")).clear();
    driver.findElement(By.id("Name-2")).sendKeys("Code");
    driver.findElement(By.id("Email-3")).clear();
    driver.findElement(By.id("Email-3")).sendKeys("codera@codera.com");
    driver.findElement(By.id("Phone-3")).clear();
    driver.findElement(By.id("Phone-3")).sendKeys("023432123");
    driver.findElement(By.id("Company-3")).click();
    driver.findElement(By.id("Company-3")).clear();
    driver.findElement(By.id("Company-3")).sendKeys("blutech");
    driver.findElement(By.id("Comments")).click();
    driver.findElement(By.id("Comments")).clear();
    driver.findElement(By.id("Comments")).sendKeys("asdfasdfasdf");
    driver.findElement(By.id("startups")).click();
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
