package excercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise18 extends  BaseClass{

	WebDriverWait wait;

	@BeforeMethod
	 void initWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	void verifyCategories() {
		
		System.out.println(driver.findElement(By.xpath("//h2[text()='Category']")).isDisplayed());
	}
	@Test(priority=2)
	void clickOnWomenCat() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Women']")).click();
	}
	
	@Test(priority=3)
	void clickOnCatProduct() {
		driver.findElement(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]")).click();
	}
	
	@Test(priority=4)
	void verifyProdctHeading() {
		
		String heading=driver.findElement(By.xpath("//h2[text()='Women - Dress Products']")).getText().toLowerCase();
		String expectedname="Women - Dress Products";
		Assert.assertEquals(expectedname.toLowerCase(), heading);
	}
	
	
	@Test(priority=5)
	void clickOnMenCat() {
		driver.findElement(By.xpath("//a[normalize-space()='Men']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Tshirts']")).click();
	}
	@Test(priority=6)
	void verifyMenCat() {
		String heading=driver.findElement(By.xpath("//h2[normalize-space()='Men - Tshirts Products']")).getText().toLowerCase();
		String expectedname="Men - Tshirts Products";
		Assert.assertEquals(expectedname.toLowerCase(), heading);
		
	}
}
