package excercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddProductCart {

	WebDriver driver;
	public AddProductCart(WebDriver driver) {
		this.driver=driver;
	}

	void clickProduct() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}
	
	
	void hoverOnFirst() {
	    // Wait until product is visible
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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


	void clickContinueShopping() {
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	}
	
	void clickOnCart() {
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
	}
	
	
	void verifyCartPage() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
	}
	void clickProceedToCheckout() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
		System.out.println("Click on checkout");
	}
	
	void clickOnRegister() {
		driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
		System.out.println("Click on Register");
	}

	void enterLoginData() {
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("princy@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
	}

	
	void testClickLogin() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	void verifyLoinText() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]")).isDisplayed();
		clickOnCart();
		clickProceedToCheckout();
	}
}
