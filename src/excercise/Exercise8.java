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

public class Exercise8 {

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
	void clickProduct() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}
	
	@Test(priority=3)
	void verifyProductPage() {
		boolean productDisplay= driver.findElement(By.xpath("//h2[normalize-space()='All Products']")).isDisplayed();
		System.out.println(productDisplay);
	} 
	
	@Test(priority=4)
	void productListDisplay() {
		List<WebElement> list= driver.findElements(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']"));
		for(WebElement item:list) {
			System.out.println(item.getText());
			System.out.println(item.isDisplayed());
		}
	}
	
	@Test(priority=5)
	void clickOnFirstProduct() {
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
	}
	
	@Test(priority=6)
	void verifyDetailsDisplay() {
		boolean productName= driver.findElement(By.xpath("//h2[text()='Blue Top']")).isDisplayed();
		boolean category=driver.findElement(By.xpath("//p[text()='Category: Women > Tops']")).isDisplayed();
		boolean price=driver.findElement(By.xpath("//span[text()='Rs. 500']")).isDisplayed();
		boolean availabilty =driver.findElement(By.xpath("//div[@class='product-details']//p[2]")).isDisplayed();
		boolean contion=driver.findElement(By.xpath("//p//b[contains(text(),'Condition')]")).isDisplayed();
		boolean brand=driver.findElement(By.xpath("//div[@class='product-details']//p[4]")).isDisplayed();
		
		System.out.println("Product name display : "+productName);
		System.out.println("category name display : "+category);
		System.out.println("price name display : "+price);
		System.out.println("availability name display : "+availabilty);
		System.out.println("condition name display : "+contion);
		System.out.println("brand name display : "+brand);
		
	}
	@AfterTest
	void closeApp() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}
}
