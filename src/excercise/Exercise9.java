package excercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Exercise9 {

	WebDriver driver;
	String searchitem ="tshirt";
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
	void testClik()  {
		
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		
	}
	
	@Test(priority = 3)
	void testProductPage()  {
		String currentUrl= driver.getCurrentUrl();
		String expectUrl="https://automationexercise.com/products";
		Assert.assertEquals(expectUrl, currentUrl);
		System.out.println("It's Product Page");
		
	}
	
	@Test(priority = 4)
	void testSearchData()  {
		
		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(searchitem);
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		
	}
	
	@Test(priority = 5)
	void testSearchedProduct() {
		
		System.out.println(driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());
	}
	
	@Test(priority=6)
	void testAllSearchedProduct() {
		List<WebElement> products=  driver.findElements(By.xpath("//div[@class='features_items']//div[@class='productinfo text-center']//p"));
		for(WebElement product: products) {
			String name=product.getText().trim().toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
			System.out.println(name);
			if(name.contains(searchitem)) {
				System.out.println("Mached....");
			}
		}
		
	}
	
	@AfterTest
	void closeApp() {
		driver.quit();
	}
	
	
	
}
