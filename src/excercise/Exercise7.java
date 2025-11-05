package excercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise7 {

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
	
	@Test(priority=2)
	void clickTestCase() {
		driver.findElement(By.xpath("//a[normalize-space()='Test Cases']")).click();
	}
	
	@Test(priority=3)
	void testTestCasesPage() {
		String currentUrl= driver.getCurrentUrl();
		String expectUrl="https://automationexercise.com/test_cases";
		Assert.assertEquals(expectUrl, currentUrl);
		System.out.println("It's Test case Page");
	}
	@AfterTest
	void closeApp() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}
}
