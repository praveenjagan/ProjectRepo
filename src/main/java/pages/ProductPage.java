package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.UtilMethods;

public class ProductPage extends UtilMethods {

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Products')]")
	WebElement eleTitle;

	public ProductPage verifyTitle() {
		String actualTitle = eleTitle.getText();
		String expetcedTitle = "Products";
		assertEquals(actualTitle, expetcedTitle, "Title is not matching");
		return this;
	}

	public ProductPage productSelection(String productName) {
		List<WebElement> prod = driver
				.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name ']"));
		System.out.println(prod.size());
		int numberOfProduct = prod.size();
		for (int i = 0; i < numberOfProduct; i++) {
			String prodText = prod.get(i).getText();
			System.out.println("Product Name " + prodText);
			if (prodText.equalsIgnoreCase(productName)) {
				System.out.println("In IF Loop");
				prod.get(i).click();
				break;
			}
		}
		return this;
	}
}
