package New;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTask {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void searchAndVerifyaProduct() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		WebElement searchField=driver.findElement(By.xpath("//input[@class='Pke_EE']"));
		searchField.sendKeys("laptop",Keys.ENTER);
		WebElement priceDrpDwn1=driver.findElement(By.xpath("//div[@class='suthUA']"));
		priceDrpDwn1.click();
		WebElement priceOption=driver.findElement(By.xpath("//div[@class='suthUA']//following-sibling::option[@value='20000']"));
		priceOption.click();
		Thread.sleep(3000);
		WebElement brandDropdwn=driver.findElement(By.xpath("//div[text()='Brand']"));
		brandDropdwn.click();
		Thread.sleep(3000);
		actions.keyDown(Keys.ALT);
		actions.keyDown(Keys.ALT);
//		WebElement brandOption=driver.findElement(By.xpath("//div[contains(text(),'HP')]//preceding-sibling::input[@type='checkbox']"));
		WebElement brandOption=driver.findElement(By.xpath("(//div[@class=\"_6i1qKy\"])[2]"));
		brandOption.click();
		Thread.sleep(3000);
		WebElement item1=driver.findElement(By.xpath("(//div[@class=\"KzDlHZ\"])[1]"));
		item1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Window Switching
		String parentWindowId=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String cwindow:windows)
		{
			if(!parentWindowId.equals(cwindow))
			{
				driver.switchTo().window(cwindow);
			}
		}
		WebElement gotoCartBtn=driver.findElement(By.xpath("//button[@class=\"QqFHMw vslbG+ In9uk2\"]"));
		gotoCartBtn.click();
		
	}
	
	
	
	
//	@AfterMethod
//	public void closeBrowser() throws InterruptedException
//	{
//		Thread.sleep(3000);
//		driver.close();
//	}
	

}
