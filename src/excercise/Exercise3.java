package excercise;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Exercise3 extends BaseClass {

	@Test(priority = 2)
	void testClikLogin() {
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
	}

	@Test(priority = 3)
	void verifyLoginPage() {
		driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
	}

	@Test(priority = 4)
	void enterLoginData() {
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("prezichristian12@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
	}

	@Test(priority = 5)
	void testClickLogin() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 6)
	void verifyText() {
		boolean istextdisplay = driver.findElement(By.xpath("//p[contains(text(),'Your email or')]")).isDisplayed();
		System.out.println(istextdisplay);
	}

}
