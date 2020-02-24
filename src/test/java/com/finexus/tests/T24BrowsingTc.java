package com.finexus.tests; 
 import io.github.bonigarcia.wdm.WebDriverManager; 
 import java.util.ArrayList;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T24BrowsingTc {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testT24BrowsingTc() throws Exception {
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("Temnos t24 banking system");
    driver.findElement(By.id("tsf")).submit();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Web result with site links'])[1]/following::h3[1]")).click();
    driver.findElement(By.linkText("get in touch")).click();
	 selectFrame(0);

    driver.findElement(By.id("768313_18887pi_768313_18887")).click();
    driver.findElement(By.id("768313_18887pi_768313_18887")).clear();
    driver.findElement(By.id("768313_18887pi_768313_18887")).sendKeys("Finexus");
    driver.findElement(By.id("768313_18889pi_768313_18889")).click();
    driver.findElement(By.id("768313_18889pi_768313_18889")).clear();
    driver.findElement(By.id("768313_18889pi_768313_18889")).sendKeys("Digital");
    driver.findElement(By.id("768313_18901pi_768313_18901")).click();
    driver.findElement(By.id("768313_18901pi_768313_18901")).clear();
    driver.findElement(By.id("768313_18901pi_768313_18901")).sendKeys("This is testing");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Comments'])[1]/following::input[3]")).click();
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
