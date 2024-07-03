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

public class RadioButtonVerificationAssi {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/radio-button-demo.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyWhthrShwBtnisEnabld()
	{
		WebElement showBtn=driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean buttnStatus=showBtn.isEnabled();
		Assert.assertEquals(buttnStatus, true);
	}
	@Test
	public void verifyWhthrMaleRdioBtnisSelected()
	{
		WebElement maleRdioBtn=driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		maleRdioBtn.click();
		boolean rdioBtnStatus=maleRdioBtn.isSelected();
		Assert.assertEquals(rdioBtnStatus, true);
	}
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}
	
	

}
