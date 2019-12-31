package com.finexus.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T24_InputAndAuthorization {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.katalon.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testT24Tc2Commit() throws Exception {
		driver.get("http://52.220.141.104:8080/BrowserWeb/servlet/BrowserServlet");
		driver.findElement(By.id("signOnName")).clear();
		driver.findElement(By.id("signOnName")).sendKeys("ALI001");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("demotest");
		driver.findElement(By.name("login")).submit();
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 |
		// ]]

//		List<WebElement> ele = driver.findElements(By.tagName("frame"));
//		System.out.println("Number of frames in a page :" + ele.size());
		Thread.sleep(10000);
		driver.switchTo().frame(1);

		driver.findElement(By.xpath("//*[@id=\"pane_\"]/ul[1]/li/span")).click();

//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
//		driver.findElement(By.linkText("Product Catalog")).sendKeys(selectLinkOpeninNewTab);

		// considering that there is only one tab opened in that point.
		String userMenuWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Product Catalog")).click();
		Thread.sleep(6000);
		ArrayList<String> productCatalogueWindow = new ArrayList<String>(driver.getWindowHandles());
		productCatalogueWindow.remove(userMenuWindow);
//		
		// change focus to new tab
		driver.switchTo().window(productCatalogueWindow.get(0));

		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1
		// | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=2 |
		// ]]

		Thread.sleep(8000);
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//*[@id=\"treestop3\"]")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Term Deposits'])[1]/following::img[1]"))
				.click();

		driver.findElement(By.xpath("//body")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame |
		// relative=parent | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=4 |
		// ]]

		// Products Script
		driver.switchTo().parentFrame();
		driver.switchTo().frame(4);

		// considering that there is only one tab opened in that point.
//		String productCatWin = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"r1\"]/td[3]/a/img")).click();
		ArrayList<String> newArrangementActivityWin = new ArrayList<String>(driver.getWindowHandles());
//		newArrangementActivityWin.remove(productCatWin);
		// change focus to new tab
		driver.switchTo().window(newArrangementActivityWin.get(2));

//		driver.findElement(By.xpath("//*[@id=\"r1\"]/td[3]/a/img")).click();
		Thread.sleep(10000);
// ********************************************* ABOVE IS VERIFIED PART ******************************************************    

//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='PB Term Deposit'])[1]/following::img[1]")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2
		// | ]]
		driver.findElement(By.id("fieldName:CUSTOMER:1")).click();
		driver.findElement(By.id("fieldName:CUSTOMER:1")).clear();
		driver.findElement(By.id("fieldName:CUSTOMER:1")).sendKeys("3008");
		driver.findElement(By.id("fieldName:CURRENCY")).click();
		driver.findElement(By.id("fieldName:CURRENCY")).clear();
		driver.findElement(By.id("fieldName:CURRENCY")).sendKeys("USD");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='New Arrangement'])[1]/preceding::img[11]"))
				.click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Arrangement'])[1]/preceding::p[1]")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [doubleClick |
		// xpath=(.//*[normalize-space(text()) and normalize-space(.)='New
		// Arrangement'])[1]/preceding::p[1] | ]]
		driver.findElement(By.linkText("Deposit Interest")).click();
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
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='New Arrangement'])[1]/preceding::img[12]"))
				.click();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
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
