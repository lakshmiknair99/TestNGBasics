package New;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableContent2 {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/table-pagination.php");
		driver.manage().window().maximize();
	}

	@Test
	public void verifyTableData() {
		List<WebElement> tDatas = driver.findElements(By.xpath("//table[@id='dtBasicExample']//td"));
		for (int i = 0; i < tDatas.size(); i++) {
			String expectedData = tDatas.get(i).getText();
			if (expectedData.equals("Cedric Kelly")) {
				System.out.println(expectedData);
			}
		}
	}

	@Test
	public void verifyTableData2() {
		List<WebElement> tHeaders = driver.findElements(By.xpath("//table[@id='dtBasicExample']//thead//tr//th"));
		for (WebElement tHeader : tHeaders) {
			String tHdrValue = tHeader.getText();
			System.out.println(tHdrValue);
		}

	}

	@Test
	public void verifyTableData3() {
		List<WebElement> tHdrs = driver.findElements(By.xpath("//table[@id='dtBasicExample']//thead//tr//th"));
		for (int i = 0; i < tHdrs.size(); i++) {
			String actualHeader = tHdrs.get(i).getText();
			String expectedHeader = "Age";
			if (actualHeader.equals(expectedHeader)) {
				System.out.println(actualHeader);
			}
		}
	}

}
