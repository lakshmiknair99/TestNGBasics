package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableExample {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/table-pagination.php");
		driver.manage().window().maximize();
	}
	@Test
	public void tableValuePrint()
	{
		WebElement tableValue1=driver.findElement(By.xpath("//table[@id='dtBasicExample']//thead//tr[1]//th[3]"));
		String text1=tableValue1.getText();
		System.out.println(text1);
		WebElement tableValue2=driver.findElement(By.xpath("//table[@id='dtBasicExample']//thead//tr[1]//th[5]"));
		String text2=tableValue2.getText();
		System.out.println(text2);
	}

}
