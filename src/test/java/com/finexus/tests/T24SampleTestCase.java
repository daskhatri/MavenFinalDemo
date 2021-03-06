package com.example.tests;

import java.util.regex.Pattern;
import java.util.ArrayList;
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
	    driver.findElement(By.id("signOnName")).clear();
	    driver.findElement(By.id("signOnName")).sendKeys("ALI001");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("demotest");
	    driver.findElement(By.id("sign-in")).click();
		 selectFrame(1);

	    driver.findElement(By.id("imgError")).click();
	    driver.findElement(By.linkText("Product Catalog")).click();
		 selectWindow(1 );
		 selectFrame(2);

	    driver.findElement(By.id("treestop3")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Term Deposits'])[1]/following::img[1]")).click();
		 selectParentFrame();
		 selectFrame(4);

	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='PB Term Deposit'])[1]/following::img[1]")).click();
		 selectWindow(2 );
	    driver.findElement(By.id("fieldName:CUSTOMER:1")).click();
	    driver.findElement(By.id("fieldName:CUSTOMER:1")).clear();
	    driver.findElement(By.id("fieldName:CUSTOMER:1")).sendKeys("3008");
	    driver.findElement(By.id("fieldName:CURRENCY")).clear();
	    driver.findElement(By.id("fieldName:CURRENCY")).sendKeys("USD");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Arrangement'])[1]/preceding::img[11]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Arrangement'])[1]/preceding::img[12]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(SG TEST)'])[1]/following::span[1]")).click();
	    driver.findElement(By.linkText("Deposit Interest")).click();
	    driver.findElement(By.id("fieldName:FIXED.RATE:1")).click();
	    driver.findElement(By.id("fieldName:FIXED.RATE:1")).click();
	    driver.findElement(By.id("fieldName:FIXED.RATE:1")).clear();
	    driver.findElement(By.id("fieldName:FIXED.RATE:1")).sendKeys("5.5");
	    driver.findElement(By.linkText("Settlement Instructions")).click();
	    driver.findElement(By.id("fieldName:PAYIN.SETTLEMENT:1")).click();
	    new Select(driver.findElement(By.id("fieldName:PAYIN.SETTLEMENT:1"))).selectByVisibleText("No");
	    driver.findElement(By.id("fieldName:PAYIN.SETTLEMENT:1")).click();
	    driver.findElement(By.id("fieldName:PAYOUT.SETTLEMENT:1")).click();
	    new Select(driver.findElement(By.id("fieldName:PAYOUT.SETTLEMENT:1"))).selectByVisibleText("No");
	    driver.findElement(By.id("fieldName:PAYOUT.SETTLEMENT:1")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Arrangement'])[1]/preceding::img[12]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(SG TEST)'])[1]/following::td[7]")).click();
  }

  public void selectFrame(int index) {
		try {
			Thread.sleep(5000);
			driver.switchTo().frame(index);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectParentFrame() {		
		driver.switchTo().parentFrame();
	}

	public void selectWindow(int index) {
		try {
			Thread.sleep(5000);
			ArrayList<String> productCatalogueWindow = new ArrayList<String>(driver.getWindowHandles());
			// change focus to new tab
			driver.switchTo().window(productCatalogueWindow.get(index));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
