package excercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise17 extends BaseClass {

	WebDriverWait wait;

	@BeforeMethod
	public void initWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	void hoverOnFirst() {
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

	@Test(priority = 2)
	void clickContinueShopping() {
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	}

	@Test(priority = 3, dependsOnMethods = { "hoverOnFirst" })
	void clickOnCart() {
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
	}

	@Test(priority = 4)
	void verifyCartPage() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
	}

	@Test(priority = 5)
	void removeProduct() {
		driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
	}

	@Test(priority = 6)
	void verifyProduct() {
		// Wait until the product row disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("product-1")));

		// Verify using size 0
		int count = driver.findElements(By.id("product-1")).size();
		Assert.assertEquals(count, 0, "Product is NOT removed from the cart!");

	}

}
