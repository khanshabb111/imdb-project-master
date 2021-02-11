package ui.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ui.helper.TestHelper;
import ui.page.SignInPage;

import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImdbTest extends TestHelper {
	private ui.page.HomePage homePage = new ui.page.HomePage(driver);
	private ui.page.WatchListPage watchListPage = new ui.page.WatchListPage(driver);

	@BeforeClass
	public static void testSetup() {
		new SignInPage(driver).loginWith("shabbirkhan2426@gmail.com", "Agustina2426.");
	}

	@Test
	@Ignore("Test requires captcha, should not automate")
	public void verifyCreateAccount() {
		// As per the selenium group and my experience, the test case with captcha is
		// not recommended and often impossible.
		// https://www.selenium.dev/documentation/en/worst_practices/captchas/
	}

	@Test
	public void __001_shouldBeAbleToAddToWatchList() {
		List<String> mediaNames = Arrays.asList("Iron Man");

		homePage.clickOnWatchiListButton().addToWatchList(mediaNames);
		List<String> watchListMovies = watchListPage.getWatchListMovies();
		Assert.assertTrue("Added Watch List movie name not matched", watchListMovies.contains(mediaNames.get(0)));

	}

	@Test
	public void __002_shouldBeAbleToRemoveFromWatchList() {

		watchListPage.deleteAllFromWatchList();
		Assert.assertEquals("", 1, watchListPage.getWatchListMediaCount());
	}

}
