package AllureReports;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({ AllureListener.class })
public class Tests extends BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		BaseClass basepage = new BaseClass();
		driver   = basepage.initializeDriver();

		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2FAdmin%2FCustomer%2FList");

	}

	@Test(priority = 1, description = "Verify message presence on Home Page")
	@Description("Verify message presence on Home Page")
	@Epic("EP001")
	@Feature("Feature1:Message")
	@Story("Story:Message presence ")
	@Step("Verify Message presence")
	@Severity(SeverityLevel.MINOR)

	public void messagePresence() {
		// boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo
		// store']")).isDisplayed();

		// Assert.assertEquals(status, true);
		System.out.println("Guru --Automations (Allure Reports)");
	}

	@Test(priority = 2)
	@Description("Verify LOgin and Landed on Home Page")
	@Epic("EP001")
	@Feature("Feature1:Login")
	@Story("Story:Valid Login ")
	@Step("Verify Login ")
	@Severity(SeverityLevel.BLOCKER)
	public void logintest() {

		// driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.getTitle(), "Customers / nopCommerce administrationMM");
	}

	@Test(priority = 3)
	@Description("Verify user Registration")
	@Epic("EP001")
	@Feature("Feature1:Registration")
	@Story("Story:user Registration")
	// @Step("Verify Login ")
	@Severity(SeverityLevel.NORMAL)
	public void registrationTest() {
		throw new SkipException("Skipping this Test");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
