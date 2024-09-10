package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import data.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class UtilMethods {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public void Login(HashMap<String, String> input) {
		LoginPage login = new LoginPage();
		login.enterUsername(input.get("username")).enterPassword(input.get("password")).clickLogin();
		System.out.println("Logged in Successfully");
	}

	@DataProvider // Getting data from json and then to hash map
	public Object[][] getData() throws IOException {
		DataReader read = new DataReader();
		List<HashMap<String, String>> data = read
				.getJsonData(System.getProperty("user.dir") + "\\src\\main\\java\\data\\TestData.json");
		return new Object[][] { { data.get(0) } };
	}

	@BeforeClass
	public void browserDetails() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\GlobalData.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver-win64_127.0.6533.72\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
}
