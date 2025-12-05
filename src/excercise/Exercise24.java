package excercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise24 extends BaseClass {

	WebDriverWait wait;

	@BeforeMethod
	void initWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	void addToCart() throws InterruptedException {
		AddProductCart addproduct = new AddProductCart(driver);
		addproduct.clickProduct();
		addproduct.hoverOnFirst();
		addproduct.clickContinueShopping();
		addproduct.clickOnCart();
		addproduct.verifyCartPage();
		addproduct.clickProceedToCheckout();
		addproduct.clickOnRegister();
		addproduct.enterLoginData();
		addproduct.testClickLogin();
		addproduct.verifyLoinText();

	}

	@Test(priority = 2)
	void placeOrder() {
		PlaceOrder placeorder = new PlaceOrder(driver, wait);
		placeorder.reviewDeliveryAddress();
		placeorder.enterComment();
		placeorder.enterPaymentDetails();
		placeorder.testOrderConfirm();
	}

	@Test(priority = 3)
	void downloadInvoice() {
		driver.findElement(By.xpath("//a[text()='Download Invoice']")).click();
	}
}
