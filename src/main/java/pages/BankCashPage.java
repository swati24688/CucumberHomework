package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankCashPage {
	
	public BankCashPage(WebDriver driver) {
		this.driver = driver;

		

	}
	WebDriver driver;
	@FindBy(how = How.LINK_TEXT, using = "Bank & Cash")
	WebElement clickBankCashButton;
	@FindBy(how = How.XPATH, using = "//a[@href='https://techfios.com/billing/?ng=accounts/add/']")
	WebElement clickNewAccountButton;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement AddAccountTitle;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement addDescription;
	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement initialBalance;
	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")
	WebElement accountNumber;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")
	WebElement contactPerson;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	WebElement phone;
	@FindBy(how = How.XPATH, using = "//input[@id='ib_url']")
	WebElement internetBankingUrl;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement submitButton;
	
	
	public void clickBanckCasshButton() {
		clickBankCashButton.click();
	}
	public void newAccountButton() {
		clickNewAccountButton.click();
	}
	public void enterAddaccountTitle(String AccountTitle){
		AddAccountTitle.sendKeys(AccountTitle);
		
	}
	public void enterDescription(String description) {
		addDescription.sendKeys(description);
		
	}
	public void enterInitialBalance(String balance) {
		initialBalance.sendKeys(balance);
		
	}
	public void enterAccountNumber(String addAccountNumber) {
		accountNumber.sendKeys(addAccountNumber);
		
	}
	public void enterContactPerson(String contact) {
		contactPerson.sendKeys(contact);
		
	}
    public void enterPhoneNumber(String phoneNumber) {
    	phone.sendKeys(phoneNumber);
    }
    public void enterInternetBankingUrl(String BankingUrl) {
    	internetBankingUrl.sendKeys(BankingUrl);
    }
    public void clickSubmitButton() {
    	submitButton.click();
    }
   
    public String accountCreated() {
		return driver.getPageSource();
    }
}

