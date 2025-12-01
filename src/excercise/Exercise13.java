package excercise;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise13  extends BaseClass{

	@Test(priority=1)
	void clickViewProduct() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement viewProduct = wait.until(
				    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/product_details/1']"))
				);

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProduct);
				viewProduct.click();

	}
	
	@Test(priority=2)
	void verifyViewProductUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
		System.out.println("It's View Product Page");
		
	}
	
	@Test(priority=3)
	void increaseQuantity()
	{
		
		WebElement quntity= driver.findElement(By.xpath("//input[@id='quantity']"));
		quntity.clear();
		quntity.sendKeys("4");
	}
	
	@Test(priority=4)
	void clickAddToCart() {
		driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
	}
	
	@Test(priority=5)
	void clickViewCart() {
		driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
	}
	
	@Test(priority=6)
	void verifyProductQunatity() {
		String quantity=driver.findElement(By.xpath("//button[normalize-space()='4']")).getText();
		Assert.assertEquals(quantity, "4");
	}
}
