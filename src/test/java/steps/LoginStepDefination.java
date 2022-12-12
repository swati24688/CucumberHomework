package steps;

import java.util.Random;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.BankCashPage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefination extends TestBase {
	private LoginPage loginPage;
	private BankCashPage bankCashPage;

	@Before
	public void setUp() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		bankCashPage = PageFactory.initElements(driver, BankCashPage.class);
	}

	@Given("^User is on the techfios login page$")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://www.techfios.com/billing/?ng=admin/");
	}

	@When("^User enters the \"([^\"]*)\" in \"([^\"]*)\" field$")
	public void user_enters_the_in_field(String loginData, String field) {

		if (field.equalsIgnoreCase("Username")) {
			loginPage.enterUserName(loginData);
			System.out.println("UserName:" + loginData);
		} else if (field.equalsIgnoreCase("Password")) {
			loginPage.enterPassword(loginData);
			System.out.println("Password:" + loginData);
		} else {
			System.out.println("Unable to enter login data:" + loginData);
		}
	}

	@And("User clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String buttonOrLink) {
 		switch (buttonOrLink) {
		case "login":
			clickOnButton(loginPage.SigninButton);
			break;
		case "bankCash":
			bankCashPage.clickBanckCasshButton();
			break;
		case "newAccount":
			bankCashPage.newAccountButton();
			break;
		case "submit":
			bankCashPage.clickSubmitButton();
		default:
		System.out.println("Unable to click button or link data:" + buttonOrLink);
		}
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_Dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals("Page not found!", expectedTitle, actualTitle);
		takeScreenshot(driver);
	}

	@Then("^User enters \"([^\"]*)\" in \"([^\"]*)\" page$")
	public void user_enters_in_page(String data, String field) {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);

		if (field.equalsIgnoreCase("AccountTitle")) {
			bankCashPage.enterAddaccountTitle(data + randomInt);
			System.out.println("AccountTitle:" + data);
		} else if (field.equalsIgnoreCase("AccountDescription")) {
			bankCashPage.enterDescription(data + randomInt);
			System.out.println("AccountDescription:" + data);
		} else if (field.equalsIgnoreCase("InitialBalance")) {
			bankCashPage.enterInitialBalance(data + randomInt);
			System.out.println("InitialBalance:" + data);
		} else if (field.equalsIgnoreCase("AccountNumber")) {
			bankCashPage.enterAccountNumber(data + randomInt);
			System.out.println("AccountNumber:" + data);
		} else if (field.equalsIgnoreCase("ContactPerson")) {
			bankCashPage.enterContactPerson(data + randomInt);
			System.out.println("ContactPerson:" + data);
		} else if (field.equalsIgnoreCase("PhoneNumber")) {
			bankCashPage.enterPhoneNumber(data + randomInt);
			System.out.println("PhoneNumber:" + data);
		} else if (field.equalsIgnoreCase("BankingUrl")) {
			bankCashPage.enterInternetBankingUrl(data + randomInt);
			System.out.println("BankingUrl:" + data);
		} else {
			System.out.println("Unable to enter data:" + data);
		}
		{

		}

	}

	@Then("^User should be able to validate account created successfully$")
	public void user_should_be_able_to_validate_account_created_successfully() {
		String expectedMessage = "Account Created Successfully";
		String pageSource = bankCashPage.accountCreated();
	
		Assert.assertTrue(pageSource.contains(expectedMessage));
		takeScreenshot(driver);
	}

	@After
	public void tearDown() {
     driver.close();
     driver.quit();
	}

}
