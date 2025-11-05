package excercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise10 {

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
	
	//scrolldownn the page
	
	@Test(priority=2)
	void scrollPage() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement footer=driver.findElement(By.xpath("//div[@class='footer-widget']"));
		
		js.executeScript("arguments[0].scrollIntoView();", footer);
		//js.executeScript("arguments[0].scrollIntoView();", scrolltext);
	}
	@Test(priority=3)
	void verifyTextSub() {
		boolean textDisplay= driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
		System.out.println(textDisplay);
	}
	
	@Test(priority=4)
	void enterEmail() {
		
		driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("prezichristian@gamil.com");
		driver.findElement(By.xpath("//button[@id='subscribe']")).click();
	}
	
	@Test(priority=5)
	void visblealert() {
		driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed();
	}
	@AfterTest
	void closeApp() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}
}

