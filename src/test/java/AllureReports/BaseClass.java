package AllureReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

	public WebDriver initializeDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		tDriver.set(driver);

		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tDriver.get();
	}

}
