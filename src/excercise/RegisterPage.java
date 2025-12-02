package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPage  {

	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
		
	@Test(priority = 1)
	public void testClikLogin()  {
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
	}
	
	@Test(priority = 2)
	public void testSignUpDisplay() {
		boolean textdisplay=driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		Assert.assertEquals(textdisplay, true,"New user signup text display");
	}
	
	@Test(priority = 3)
	public void enterData() {
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Prince12");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("princechri@gmail.com");
	}
	@Test(priority = 4)
	public void clickSignupBtn() {
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
	}
}
