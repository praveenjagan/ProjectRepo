package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.UtilMethods;

public class LoginPage extends UtilMethods {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "user-name")
	WebElement eleUsername;

	public LoginPage enterUsername(String uname) {
		eleUsername.sendKeys(uname);
		return this;
	}

	@FindBy(how = How.NAME, using = "password")
	WebElement elePassword;

	public LoginPage enterPassword(String pword) {
		elePassword.sendKeys(pword);
		return this;
	}

	@FindBy(how = How.CLASS_NAME, using = "submit-button")
	WebElement eleLogin;

	public ProductPage clickLogin() {
		eleLogin.click();
		return new ProductPage();
	}

}
