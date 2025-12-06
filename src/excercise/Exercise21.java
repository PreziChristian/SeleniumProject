package excercise;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise21 extends BaseClass {

	@Test(priority = 1)
	void clickProduct() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}

	@Test(priority = 2)
	void verifyProductPage() {
		Assert.assertEquals("https://automationexercise.com/products", driver.getCurrentUrl());
	}

	@Test(priority = 3)
	void clickOnViewProduct() {
		driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]")).click();
	}

	@Test(priority = 4)
	void verifyText() {
		System.out.println(driver.findElement(By.xpath("//a[text()='Write Your Review']")).isDisplayed());
	}

	@Test(priority = 5)
	void enterReview() {
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Prezi");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prezi@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='review']")).sendKeys("Nice product");
	}

	@Test(priority = 6)
	void clickOnSubmit() {
		driver.findElement(By.xpath("//button[@id='button-review']")).click();
	}

	@Test(priority = 7)
	void checkSuccessMsg() {

		System.out.println("success"
				+ driver.findElement(By.xpath("(//span[text()='Thank you for your review.'])[1]")).isDisplayed());
	}
}
