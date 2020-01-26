package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class T24SampleTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testT24SampleTestCase() throws Exception {
    driver.get("http://52.220.141.104:8080/BrowserWeb/servlet/BrowserServlet");
    driver.findElement(By.id("signOnName")).click();
    driver.findElement(By.id("signOnName")).click();
    driver.findElement(By.id("signOnName")).clear();
    driver.findElement(By.id("signOnName")).sendKeys("ALI001");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("demotest");
    driver.findElement(By.id("sign-in")).click();
    ERROR: Unsupported command [selectFrame | index=1 | ]
    driver.findElement(By.id("imgError")).click();
    driver.findElement(By.linkText("Product Catalog")).click();
    ERROR: Unsupported command [selectWindow | win_ser_1 | ]
    ERROR: Unsupported command [selectFrame | index=2 | ]
    driver.findElement(By.id("treestop1")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Current Accounts'])[1]/following::img[1]")).click();
    ERROR: Unsupported command [selectFrame | relative=parent | ]
    ERROR: Unsupported command [selectFrame | index=4 | ]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='BMO Call Account'])[1]/following::img[1]")).click();
    ERROR: Unsupported command [selectWindow | win_ser_2 | ]
    driver.findElement(By.id("fieldName:CUSTOMER:1")).click();
    driver.findElement(By.id("fieldName:CUSTOMER:1")).clear();
    driver.findElement(By.id("fieldName:CUSTOMER:1")).sendKeys("3008");
    driver.findElement(By.id("fieldName:CURRENCY")).clear();
    driver.findElement(By.id("fieldName:CURRENCY")).sendKeys("USD");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Arrangement'])[1]/preceding::img[11]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Arrangement'])[1]/preceding::img[12]")).click();
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
