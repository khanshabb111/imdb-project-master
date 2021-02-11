package ui.helper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class TestHelper {
	public static WebDriver driver;

	@BeforeClass
	public static void setupDriver() {
		driver = CommonHelper.loadDriver(Constants.DEFAULT_DRIVER);
		driver.get("https://www.imdb.com");
	}

	@AfterClass
	public static void teardownDriver() {
		 CommonHelper.quitDriver();
	}
}