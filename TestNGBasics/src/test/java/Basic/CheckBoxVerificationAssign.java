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

public class CheckBoxVerificationAssign {
	
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyHdrMultiChkBox()
	{
		String expectedHeader="Multiple Checkbox Demo";
		WebElement header=driver.findElement(By.xpath("//div[contains(text(),'Multiple Checkbox Demo')]"));
		String actualHeader=header.getText();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	@Test
	public void verifyWhthrCheckBx1Deselected()
	{
		WebElement checkBox1=driver.findElement(By.xpath("//input[@id='check-box-one']"));
		boolean chechkBxStatus=checkBox1.isSelected();
		Assert.assertEquals(chechkBxStatus, false);
	}
	@Test
	public void verifyWhthrCheckBx2isselectedAftrClick()
	{
		WebElement checkBox2=driver.findElement(By.xpath("//input[@id='check-box-two']"));
		checkBox2.click();
		boolean checkBx2Status=checkBox2.isSelected();
		Assert.assertEquals(checkBx2Status, true);
	}
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}	

}
