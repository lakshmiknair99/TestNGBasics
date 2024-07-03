package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionExamples {
	WebDriver driver;
	SoftAssert softassert = new SoftAssert();


	@BeforeMethod
	public void launchBrowser() {

		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/jquery-progress-bar.php");
		driver.manage().window().maximize();
	}

	@Test
	public void verifyjqueryTitle() {
		
		WebElement jqueryTitle=driver.findElement(By.xpath("//div[contains(text(),'JQuery UI Progress bar - Download Dialog')]"));
		String actualTitle = jqueryTitle.getText();
		String expectedTitle = "JQuery UI Progress bar - Download Dialo";
		System.out.println(actualTitle);
	//	Assert.assertEquals(actualTitle, expectedTitle);
		softassert.assertEquals(actualTitle, expectedTitle);
	//	System.out.println("Title");
		//hard assert can be given only one
		WebElement startDwnldBtn=driver.findElement(By.xpath("//button[@id='downloadButton']"));
		boolean btnStatus=startDwnldBtn.isEnabled();
		softassert.assertTrue(btnStatus);
		String btnText=startDwnldBtn.getText();
		String expectedBtnText="Start Download";
		softassert.assertEquals(btnText, expectedBtnText);
		softassert.assertAll(); 
	}
}
