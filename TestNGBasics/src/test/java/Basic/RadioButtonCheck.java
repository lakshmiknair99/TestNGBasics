package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonCheck

{
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();

	}

	@Test
	public void VerifyHeader() {
		WebElement Multibox = driver.findElement(By.xpath("(//div[@class='card-header'])[3]"));
		String ActualBtnname1 = Multibox.getText();
		System.out.println(ActualBtnname1);
		String ActualBtnname11 = "Multiple Checkbox Demo";
		Assert.assertEquals(ActualBtnname1, ActualBtnname11);
	}

	@Test
	public void CheckDeselected() {
		WebElement Checkbox1 = driver.findElement(By.xpath("//input[@id='check-box-one']"));
		Boolean Status = Checkbox1.isSelected();
		Assert.assertFalse(Status);
	}

	@Test
	public void CheckIsselected() {
		WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='check-box-two']"));
		checkBox2.click();
		Boolean status = checkBox2.isSelected();
		Assert.assertEquals(true, status);

	}

}
