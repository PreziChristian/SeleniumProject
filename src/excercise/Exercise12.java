package excercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise12 extends BaseClass {

	
	
	@Test(priority=2)
	void clickProduct() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}
	
	@Test(priority=3)
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

	
@Test(priority=4)
	void clickContinueShopping() {
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	}
	

@Test(priority=5)
void hoverOnSecond() {
    // Wait until product is visible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("(//div[@class='productinfo text-center'])[2]")));

    // Scroll into view (helps if element is off screen)
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", product);

    // Hover on product
    Actions action = new Actions(driver);
    action.moveToElement(product).perform();

    // Wait and click Add to Cart
    WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("(//a[contains(text(),'Add to cart')])[4]")));
    addToCart.click();

    clickContinueShopping();
}

	@Test(priority=6)
	void clickCart() {
		driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
	}
	
	
	@Test(priority=7)
	void verifyAllProduct() {
		
		List<WebElement> list= driver.findElements(By.xpath("//table[@class='table table-condensed']//tbody//tr"));
		
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
		
			System.out.println(list.get(i+1).getText()+ list.get(i+1).isDisplayed());
			System.out.println("Price : "+driver.findElement(By.xpath("(//td[@class='cart_price'])["+(i+1)+"]")).isDisplayed());
			System.out.println("Quantity : " +driver.findElement(By.xpath("(//td[@class='cart_quantity'])["+(i+1)+"]")).isDisplayed());
			System.out.println("Total : "+driver.findElement(By.xpath("(//td[@class='cart_total'])["+(i+1)+"]")).isDisplayed());
		
		
		}
	}
	}
		
	
	
