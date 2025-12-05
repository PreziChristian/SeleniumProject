package excercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise20 extends BaseClass {
	String searchitem = "tshirt";

	@Test(priority = 1)
	void clickProduct() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}

	@Test(priority = 2)
	void verifyProductPage() {
		Assert.assertEquals("https://automationexercise.com/products", driver.getCurrentUrl());
	}

	@Test(priority = 3)
	void testSearchData() {

		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(searchitem);
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();

	}

	@Test(priority = 4)
	void testSearchedProduct() {

		System.out.println(driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());
	}

	@Test(priority = 5)
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

	@Test(priority = 6)
	void hoverOnFirst() {
		// Wait until product is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement product = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='productinfo text-center'])[1]")));

		// Scroll into view (helps if element is off screen)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

		// Hover on product
		Actions action = new Actions(driver);
		action.moveToElement(product).perform();

		// Wait and click Add to Cart
		WebElement addToCart = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn btn-default add-to-cart'])[2]")));
		addToCart.click();
	}

	@Test(priority = 7)
	void clickContinueShopping() {
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	}

	@Test(priority = 8, dependsOnMethods = { "hoverOnFirst" })
	void clickOnCart() {
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
	}

	@Test(priority = 9)
	void verifyCartPage() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
	}

	@Test(priority = 10)
	public void verifyProductsInCart() {

		// List of expected products
		String[] expectedProducts = { "Men Tshirt" };

		for (String product : expectedProducts) {

			String xpath = "//td[@class='cart_description']//a[contains(text(),'" + product + "')]";
			Assert.assertTrue(driver.findElements(By.xpath(xpath)).size() > 0, product + " is NOT present in cart!");
		}
	}

	@Test(priority = 11)
	void clickOnRegister() {
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		System.out.println("Click on Register");
	}

	@Test(priority = 12, dependsOnMethods = { "clickOnRegister" })
	void enterLoginData() {
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("princy@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
	}

	@Test(priority = 13)
	void testClickLogin() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 14)
	void verifyLoinText() {
		driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]")).isDisplayed();
		clickOnCart();
		verifyProductsInCart();

	}

}
