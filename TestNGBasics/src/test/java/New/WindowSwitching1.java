package New;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitching1 {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/window-popup.php");
		driver.manage().window().maximize();
	}

	@Test
	public void switchWindow() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String parentWndID = driver.getWindowHandle();
		WebElement btn1 = driver.findElement(By.xpath("//a[@class=\"btn btn-primary windowSingle\"]"));
		btn1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Set<String> windows = driver.getWindowHandles();

		for (String cWindow : windows) {
			if (!parentWndID.equals(cWindow)) {
				driver.switchTo().window(cWindow);
			}
		}
		String expectedTitle = "See more on Facebook";
		WebElement title = driver.findElement(By.xpath("(//span[contains(text(),'See more on Facebook')])[1]"));
		String actualTitle = title.getText();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
