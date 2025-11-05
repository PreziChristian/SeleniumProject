package excercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage {

	WebDriver driver;


	@BeforeClass
	public void openAPP() {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://automationexercise.com");
		driver.manage().window().maximize();
		
		String currentUrl= driver.getCurrentUrl();
		String expectUrl="https://automationexercise.com/";
		Assert.assertEquals(expectUrl, currentUrl);
		System.out.println("It's Home Page");

	
	}
	
	@Test
	void registerPage() {
		RegisterPage register=new RegisterPage(driver);
		register.testClikLogin();
		register.testSignUpDisplay();
		register.enterData();
		register.clickSignupBtn();
	}
	
	@AfterClass
	public void closeApp() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}
	
	
}
