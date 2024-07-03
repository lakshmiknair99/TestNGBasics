package New;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableContent {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/table-pagination.php");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyTableData()
	{
		List<WebElement> tRows=driver.findElements(By.xpath("//table[@id='dtBasicExample']//tr"));
		for(WebElement tRow:tRows)
		{
			List<WebElement> tDatas=driver.findElements(By.xpath("//table[@id='dtBasicExample']//td"));
			for(WebElement tData:tDatas)
			{
				String data=tData.getText();
				System.out.println(data);
			}
		}
	}

}
