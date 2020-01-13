
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TEST1 {
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
	public void test1() throws Exception {
		driver.get("http://10.1.137.18:8080/MCBDEV/servlet/BrowserServlet");
		driver.findElement(By.id("signOnName")).click();
		driver.findElement(By.id("signOnName")).clear();
		driver.findElement(By.id("signOnName")).sendKeys("ALI001");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("12341234");
		driver.findElement(By.name("login")).submit();
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 |
		// ]]
		driver.findElement(By.linkText("Product Catalog")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1
		// | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=2 |
		// ]]
		driver.findElement(By.id("treestop6")).click();
		driver.findElement(By.xpath("(//img[@alt='Products'])[5]")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame |
		// relative=parent | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=4 |
		// ]]
		driver.findElement(By.xpath("//img[@alt='New Arrangement']")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2
		// | ]]
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
