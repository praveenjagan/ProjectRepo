package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.UtilMethods;

public class PaymentInfomationPage extends UtilMethods {

	public PaymentInfomationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@class='summary_info']//div[2]")
	WebElement elePaymentInfomation;

	public PaymentInfomationPage verifyPaymentInfo() {
		String PayInfo = elePaymentInfomation.getText();
		System.out.println("Payment Information: " + PayInfo);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//*[@class='summary_info']//div[4]")
	WebElement eleShippingInfomation;

	public PaymentInfomationPage verifyShippingInfo() {
		String ShipInfo = eleShippingInfomation.getText();
		System.out.println("Shipping Information: " + ShipInfo);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//*[@class='summary_info']//div[6]")
	WebElement elePriceTotal;

	public PaymentInfomationPage verifyPriceTotal() {
		String PriceTotal = elePriceTotal.getText();
		System.out.println("Price Total: " + PriceTotal);
		return this;
	}

	@FindBy(how = How.ID, using = "finish")
	WebElement eleFinishButton;

	public ConfirmOrderPage clickFinishButton() {
		eleFinishButton.click();
		return new ConfirmOrderPage();
	}
}
