package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import New.DataProviders;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderAssign {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/form-submit.php");
		driver.manage().window().maximize();
	}
	@Test(dataProvider = "personal_details",dataProviderClass = DataProviders.class)
	public void verifyPersonDetails(String fName, String lName, String uName, String city, String state, String zip)
	{
		WebElement fnameField=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		fnameField.sendKeys(fName);
		WebElement lnameField=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		lnameField.sendKeys(lName);
		WebElement unameField=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		unameField.sendKeys(uName);
		WebElement cityField=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		cityField.sendKeys(city);
		WebElement stateField=driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		stateField.sendKeys(state);
		WebElement zipField=driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		zipField.sendKeys(zip);
		WebElement termsConditionCheckbx=driver.findElement(By.xpath("//label[contains(text(),'Agree to terms and conditions')]//preceding-sibling::input[@id='invalidCheck']"));
		termsConditionCheckbx.click();
		WebElement submitBtn=driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		submitBtn.click();
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}

}
