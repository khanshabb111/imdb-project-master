package ui.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageHelper {
	public WebDriver driver;

	public PageHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(By locator) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}

	public void setDataField(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public List<String> getStringList(By by) {
		List listString = new ArrayList();
		List<WebElement> elements = driver.findElements(by);
		for (WebElement element : elements) {
			listString.add(element.getText().trim());
		}
		return listString;
	}

	public void clickOnElementWithJS(By checkAllLocator2) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(checkAllLocator2));
	}
}
