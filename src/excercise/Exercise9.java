package excercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise9 extends BaseClass {

	String searchitem = "tshirt";

	@Test(priority = 2)
	void testClik() {

		driver.findElement(By.xpath("//a[@href='/products']")).click();

	}

	@Test(priority = 3)
	void testProductPage() {
		String currentUrl = driver.getCurrentUrl();
		String expectUrl = "https://automationexercise.com/products";
		Assert.assertEquals(expectUrl, currentUrl);
		System.out.println("It's Product Page");

	}

	@Test(priority = 4)
	void testSearchData() {

		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(searchitem);
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();

	}

	@Test(priority = 5)
	void testSearchedProduct() {

		System.out.println(driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());
	}

	@Test(priority = 6)
	void testAllSearchedProduct() {
		List<WebElement> products = driver
				.findElements(By.xpath("//div[@class='features_items']//div[@class='productinfo text-center']//p"));
		for (WebElement product : products) {
			String name = product.getText().trim().toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
			System.out.println(name);
			if (name.contains(searchitem)) {
				System.out.println("Mached....");
			}
		}

	}

}
