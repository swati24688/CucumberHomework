package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "username")
	public WebElement Username;
	@FindBy(how = How.ID, using = "password")
	public WebElement Password;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-success block full-width']")
	public WebElement SigninButton;

	public void enterUserName(String username) {

		Username.sendKeys(username);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);

	}

	public void clickSigninButton() {
		SigninButton.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	

}
