package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;
import utils.UtilMethods;

public class TC001_Login extends UtilMethods{
	
	@Test
	public void login() {
		LoginPage login = new LoginPage();
		login.enterUsername().enterPassword().clickLogin();
		ProductPage product = new ProductPage();
		product.verifyTitle().productSelection("Sauce Labs Backpack");
	}
}
