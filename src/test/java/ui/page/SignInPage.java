package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.CommonHelper;
import ui.helper.PageHelper;

public class SignInPage extends PageHelper {

	private By signIn = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[6]/a/div");
	private By signInWithImdb = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]/span[2]");
	private By inputEmail = By.name("email");
	private By inputPassword = By.name("password");
	private By signInButton = By.id("signInSubmit");

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	public void loginWith(String username, String pass) {
		clickOnElement(signIn);
		clickOnElement(signInWithImdb);
		setDataField(inputEmail, username);
		setDataField(inputPassword, pass);
		clickOnElement(signInButton);
	}
}
