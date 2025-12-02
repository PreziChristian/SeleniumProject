package excercise;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise23 extends BaseClass{

	@Test(priority=1)
	void signup() {
		RegisterPage register= new RegisterPage(driver);
		register.testClikLogin();
		register.testSignUpDisplay();
		register.enterData();
		register.clickSignupBtn();
	}
	@Test(priority=2)
	void addToCart() throws InterruptedException {
		AddProductCart addproduct=new AddProductCart(driver);
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
	
	@Test(priority=3)
	void verifyAddress() {
		
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][text()='Ahmedabad']")).getText(), "Ahmedabad");
	}
	
	@Test(priority=4)
	void verifyBillingAddres() {
		
		Assert.assertEquals(  driver.findElement(By.xpath("//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][text()='Ahmedabad']")).getText(), "Ahmedabad");
	}
	
	
}
