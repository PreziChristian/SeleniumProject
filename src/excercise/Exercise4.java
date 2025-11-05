package excercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise4 {

	WebDriver driver;
	@BeforeTest
	void openAPP() {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://automationexercise.com");
		driver.manage().window().maximize();
	}
	
	
	@Test(priority = 1)
	void testHomePage()  {
		String currentUrl= driver.getCurrentUrl();
		String expectUrl="https://automationexercise.com/";
		Assert.assertEquals(expectUrl, currentUrl);
		System.out.println("It's Home Page");

		
		
	}
	@Test(priority = 2)
	void testClikLogin()  {
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
	}
	
	@Test(priority=3)
	void verifyLoginPage() {
		driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
	}
	
	@Test(priority=4)
	void enterLoginData() {
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("prezichristian@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
	}
	@Test(priority=5)
	void testClickLogin() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority=6)
	void verifyLoinText() {
		driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]")).isDisplayed();
	}
	
	@Test(priority=7)
	void clickLogout() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}
	@Test(priority = 8)
	void testLoginPage()  {
		String currentUrl= driver.getCurrentUrl();
		String expectUrl="https://automationexercise.com/login";
		Assert.assertEquals(expectUrl, currentUrl);
		System.out.println("It's Login Page");

		
		
	}
	@AfterTest
	void closeApp() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}
	
	
}
