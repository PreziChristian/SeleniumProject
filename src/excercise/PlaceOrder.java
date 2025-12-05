package excercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PlaceOrder {

	WebDriver driver;
	WebDriverWait wait;

	public PlaceOrder(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	@Test(priority = 11)
	void reviewDeliveryAddress() {
		System.out.println("In review");
		WebElement addressBlock = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='address_delivery']")));
		System.out.print("After address");
		List<WebElement> addressLines = addressBlock.findElements(By.tagName("li"));

		for (WebElement line : addressLines) {
			String text = line.getText().trim();
			if (!text.isEmpty()) {
				System.out.println(text);
			}
		}
	}

	@Test(priority = 12)
	void reviewProduct() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart_info table")));
		List<WebElement> rows = driver.findElements(By.cssSelector("#cart_info table tbody tr"));
		for (WebElement row : rows) {
			String price = row.findElement(By.cssSelector(".cart_price")).getText();

			String total = row.findElement(By.cssSelector(".cart_total")).getText();

			System.out.println("Price: " + price);
			System.out.println("Total: " + total);

		}
	}

	@Test(priority = 13)
	void enterComment() {
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Testing.....");
		driver.findElement(By.xpath("//a[text()='Place Order']")).click();
	}

	@Test(priority = 14)
	void enterPaymentDetails() {
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Princy");
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("123456789121");
		driver.findElement(By.xpath("//input[@class='form-control card-cvc']")).sendKeys("345");
		driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2026");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	@Test(priority = 15)
	void testOrderConfirm() {
		driver.findElement(By.xpath("//p[contains(.,'Congratulations!')]")).isDisplayed();
	}

}
