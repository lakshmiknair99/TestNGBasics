package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample {
	WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyWhthrAllCheckbxsEnabld() 
	{
		List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement checkBox:checkBoxes)
		{
			boolean status=checkBox.isEnabled();
			softAssert.assertTrue(status);
			
		}
			
	}
	

}
