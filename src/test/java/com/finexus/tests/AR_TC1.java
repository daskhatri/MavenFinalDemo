package com.finexus.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ARTC1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testARTC1() throws Exception {
    driver.get("http://52.220.141.104:8080/BrowserWeb/servlet/BrowserServlet");
    driver.findElement(By.id("signOnName")).clear();
    driver.findElement(By.id("signOnName")).sendKeys("ALI001");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("12345678");
    driver.findElement(By.name("login")).submit();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
    driver.findElement(By.linkText("Product Catalog")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=2 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Term Deposits'])[1]/following::td[3]")).click();
    driver.findElement(By.id("treestop3")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Term Deposits'])[1]/following::img[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=4 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='PB Term Deposit'])[1]/following::img[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
  }

  @After
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
