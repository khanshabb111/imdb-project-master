package ui.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CommonHelper {

	private static final int PAGE_LOAD_TIMEOUT = 60;
	private static final int DEFAULT_DRIVER_TIMEOUT = 5;
	public static WebDriver driver;

	public static WebDriver loadDriver(String driverType) {
		if (driverType.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		}
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(DEFAULT_DRIVER_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}