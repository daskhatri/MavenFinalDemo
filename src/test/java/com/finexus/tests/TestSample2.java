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
//public class TestSample2 {
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
//  public void testSample2() throws Exception {
//    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//    driver.findElement(By.id("txtUsername")).click();
//    driver.findElement(By.id("txtUsername")).clear();
//    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//    driver.findElement(By.id("txtPassword")).clear();
//    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//    driver.findElement(By.id("btnLogin")).click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Directory'])[1]/following::b[1]")).click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dashboard'])[1]/following::b[1]")).click();
//    driver.findElement(By.id("searchDirectory_emp_name_empName")).click();
//    driver.findElement(By.id("searchDirectory_emp_name_empName")).clear();
//    driver.findElement(By.id("searchDirectory_emp_name_empName")).sendKeys("Lind");
//    driver.findElement(By.id("search_form")).submit();
//    driver.findElement(By.id("searchBtn")).click();
//    driver.findElement(By.id("welcome")).click();
//    driver.findElement(By.linkText("Logout")).click();
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
