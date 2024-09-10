package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.UtilMethods;

public class AddToCartPage extends UtilMethods {

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "add-to-cart")
	WebElement eleAddToCartButton;

	public AddToCartPage clickAddToCartButton() {
		eleAddToCartButton.click();
		System.out.println("Add to cart successfully");
		return this;
	}

	@FindBy(how = How.XPATH, using = "//*[@class='shopping_cart_link']//span")
	WebElement eleShoppingCart;

	public AddToCartPage verifyProductCount() {
		System.out.println("In Verify Prod Count");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(eleShoppingCart));
		String ProdCount = eleShoppingCart.getText();
		System.out.println("Added Product Count is " + ProdCount);
		return this;
	}

	public AddToCartPage clickProductCount() {
		eleShoppingCart.click();
		return this;
	}

	@FindBy(how = How.ID, using = "checkout")
	WebElement eleCheckout;

	public CheckoutPage clickCheckOut() {
		eleCheckout.click();
		return new CheckoutPage();
	}

}
