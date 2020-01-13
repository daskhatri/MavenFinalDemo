package com.finexus.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavFDOrangeCRM {
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
  public void testMavFDOrangeCRM() throws Exception {
    driver.get("https://opensource-demo.orangehrmlive.com/");
    driver.findElement(By.id("txtUsername")).click();
    driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LOGIN Panel'])[1]/following::span[1]")).click();
    driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("admin");
    driver.findElement(By.id("txtPassword")).click();
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
    driver.findElement(By.id("menu_time_Reports")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Assign Leave'])[1]/following::b[1]")).click();
    driver.findElement(By.id("menu_time_Reports")).click();
    driver.findElement(By.id("menu_time_displayProjectReportCriteria")).click();
    driver.findElement(By.id("time_project_name")).click();
    driver.findElement(By.id("time_project_name")).click();
    driver.findElement(By.id("welcome")).click();
    driver.findElement(By.linkText("Logout")).click();
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
