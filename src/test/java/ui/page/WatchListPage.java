package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ui.helper.Constants;
import ui.helper.PageHelper;

import java.util.List;

public class WatchListPage extends PageHelper {

	private By editLink = By.cssSelector("[title='Edit']");
	private By searchField = By.id("add-to-list-search");
	private By searchedMediaNameLink = By.xpath("//*[@id=\"add-to-list-search-results\"]/a[1]/div/span[1]");
	private By arrayList = By.partialLinkText("Man");
	private By watchListCounterLocator = By.xpath("//div[text()='Watchlist']");
	private By editButtonLocator = By.xpath("//span[text()='EDIT']");
	private By checkAllLocator = By.id("totalCheck");
	private By confirmDeleteBy = By.cssSelector("[value='DELETE']");
	private By deleteAllButtonSelector = By.id("delete_items");

	public WatchListPage(WebDriver driver) {
		super(driver);
	}

	public void addToWatchList(List<String> mediaNames) {
		for (String mediaName : mediaNames) {
			clickOnElement(editLink);
			setDataField(searchField, mediaName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clickOnElement(searchedMediaNameLink);
		}
	}

	public List<String> getWatchListMovies() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getStringList(arrayList);
	}

	public void deleteAllFromWatchList() {
		if (driver.findElements(watchListCounterLocator).size() > 0) {
			clickOnElement(watchListCounterLocator);
			clickOnElement(editButtonLocator);
			clickOnElementWithJS(checkAllLocator);
			clickOnElement(deleteAllButtonSelector);
			clickOnElement(confirmDeleteBy);
		}

	}

	public int getWatchListMediaCount() {
		return driver.findElements(watchListCounterLocator).size();
	}
}
