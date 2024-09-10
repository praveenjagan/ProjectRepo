package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.UtilMethods;

public class ConfirmOrderPage extends UtilMethods {

	public ConfirmOrderPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@class='complete-header']")
	WebElement eleVerifyMessage;

	public ConfirmOrderPage verifySuccessMessage() {
		String actualMessage = "Thank you for your order!";
		String expectedMessage = eleVerifyMessage.getText();
		assertEquals(actualMessage, expectedMessage, "Booking is confirmed successfully");
		return this;
	}
}
