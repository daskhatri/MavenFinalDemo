//package com.finexus.tests;
//
//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
//import org.testng.annotations.*;
//import static org.testng.Assert.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class T24ExperimentalTC {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
//
//  @BeforeClass(alwaysRun = true)
//  public void setUp() throws Exception {
//    driver = new ChromeDriver();
//    baseUrl = "https://www.katalon.com/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }
//
//  @Test
//  public void testT24ExperimentalTC() throws Exception {
//    driver.get("http://52.220.141.104:8080/BrowserWeb/servlet/BrowserServlet");
//    driver.findElement(By.id("signOnName")).clear();
//    driver.findElement(By.id("signOnName")).sendKeys("INPUTT");
//    driver.findElement(By.id("password")).clear();
//    driver.findElement(By.id("password")).sendKeys("12341234");
//    driver.findElement(By.name("login")).submit();
//    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
//    driver.findElement(By.id("imgError")).click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Product Catalog'])[1]/following::span[1]")).click();
//    driver.findElement(By.linkText("Find Account")).click();
//  }
//
//  @AfterClass(alwaysRun = true)
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }
//
//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
//}
