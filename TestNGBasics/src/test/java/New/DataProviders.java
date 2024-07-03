package New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviders {
	@DataProvider(name = "products")
	public Object[][] searchProduct() {
		return new Object[][] { { "shoe" }, { "watch" }, { "phone" } };
	}

	@DataProvider(name = "credentials")
	public Object[][] searchCredentials() {
		return new Object[][] { { "lakshmi", "dyrtuy5" }, { "akhila", "cytgukhk" }, { "anu", "tyuyfuty" } };
	}

	@DataProvider(name="personal_details")
	public Object[][] enterDetails(){
		return new Object[][] { {"anakha", "s", "anakha@s", "kochi", "kerala", "678967"}, {"anila", "s", "anila1234@s", "kochi", "kerala", "678459"}, {"Janu", "k", "jan@k5", "kottayam", "kerala", "686607 "} };
	}
}
