package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		
		WebDriverManager.chromedriver().setup(); //equivalent to system.setproperty()
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
	}
	@Test(priority=1,enabled=false)
	public void verifyTitle()
	{
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Obsqura Testin";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Failed becoz expected and actual are not equal");
		
	}
	@Test(dependsOnMethods ="verifyWhethrShowMsgisEnabld")
	public void verifyShowMessage()
	{
		WebElement msgBtn=driver.findElement(By.xpath("//button[@id='button-one']"));
		String actualBtnName=msgBtn.getText();
		System.out.println(actualBtnName);
		String expectedBtnName="Show Message";
		Assert.assertEquals(actualBtnName, expectedBtnName);
		
	}
	@Test(invocationCount=2)
	public void verifyWhethrShowMsgisEnabld()
	{
		WebElement msgBtn=driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean btn=msgBtn.isEnabled();
	//	Assert.assertEquals(btn, true);
	//	Assert.assertTrue(btn); //Expect True
		Assert.assertFalse(btn);
	 
	}

	
	
	

}
