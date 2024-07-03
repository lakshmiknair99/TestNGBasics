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

public class DataProviderExample {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	//	driver.get("https://www.amazon.in/");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	@Test(dataProvider="products",dataProviderClass=DataProviders.class)
	public void verifyProductDetails(String product)
	{
		WebElement searchbox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbox.sendKeys(product);
		System.out.println(product);
		WebElement searchbutton=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbutton.click();
	}
	@Test(dataProvider="credentials",dataProviderClass=DataProviders.class)
	public void facebookLogin(String username, String password)
	{
		WebElement userName= driver.findElement(By.xpath("//input[@id='email']"));
		userName.sendKeys(username);
		System.out.println("Username: "+username);
		WebElement passwrd= driver.findElement(By.xpath("//input[@id='pass']"));
		passwrd.sendKeys(password);
		System.out.println("Password: "+password);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
