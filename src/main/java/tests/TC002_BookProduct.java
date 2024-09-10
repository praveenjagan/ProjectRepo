package tests;

import java.util.HashMap;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.ConfirmOrderPage;
import pages.LoginPage;
import pages.PaymentInfomationPage;
import pages.ProductPage;
import utils.UtilMethods;

public class TC002_BookProduct extends UtilMethods {

	@Test(dataProvider = "getData")
	public void addToCart(HashMap<String, String> input) {
		LoginPage login = new LoginPage();
		login.enterUsername(input.get("username")).enterPassword(input.get("password")).clickLogin();

		ProductPage product = new ProductPage();
		product.verifyTitle().productSelection("Sauce Labs Backpack");

		AddToCartPage cart = new AddToCartPage();
		cart.clickAddToCartButton().verifyProductCount().clickProductCount().clickCheckOut();

		CheckoutPage check = new CheckoutPage();
		check.enterFirstName().enterLastName().enterPostalCode().clickContinue();

		PaymentInfomationPage payment = new PaymentInfomationPage();
		payment.verifyPaymentInfo().verifyShippingInfo().verifyPriceTotal().clickFinishButton();
		
		ConfirmOrderPage confirm = new ConfirmOrderPage();
		confirm.verifySuccessMessage();

	}
}
