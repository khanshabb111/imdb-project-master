package ui.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.PageHelper;

public class HomePage extends PageHelper {
    private By watchList = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WatchListPage clickOnWatchiListButton() {
        clickOnElement(watchList);
        return new WatchListPage(driver);
    }
}
