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

public class Exercise14 extends BaseClass {

	WebDriverWait wait;

	@BeforeMethod
	public void initWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	void clickProduct() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}
	
	@Test(priority=2)
	void hoverOnFirst() {
	    // Wait until product is visible
	    WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("(//div[@class='productinfo text-center'])[1]")));

	    // Scroll into view (helps if element is off screen)
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", product);

	    // Hover on product
	    Actions action = new Actions(driver);
	    action.moveToElement(product).perform();

	    // Wait and click Add to Cart
	    WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("(//a[@class='btn btn-default add-to-cart'])[2]")));
	    addToCart.click();
	}

	
@Test(priority=3)
	void clickContinueShopping() {
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	}
	

	@Test(priority = 4,dependsOnMethods = {"hoverOnFirst"})
	void clickOnCart() {
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
	}

	@Test(priority = 5)
	void verifyCartPage() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
	}

	@Test(priority = 6)
	void clickProceedToCheckout() {
		driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
		System.out.println("Click on checkout");
	}

	@Test(priority = 7)
	void clickOnRegister() {
		driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
		System.out.println("Click on Register");
	}

	@Test(priority = 8)
	void enterLoginData() {
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("princy@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
	}

	@Test(priority = 9)
	void testClickLogin() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 10)
	void verifyLoinText() {
		driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]")).isDisplayed();
		clickOnCart();
		clickProceedToCheckout();
	}
	
	@Test(priority = 11)
	void placeorder() {
	PlaceOrder placeOrder=new PlaceOrder(driver, wait);
	placeOrder.reviewDeliveryAddress();
	placeOrder.reviewProduct();
	placeOrder.enterComment();
	placeOrder.enterPaymentDetails();
	placeOrder.testOrderConfirm();
	
	}

}