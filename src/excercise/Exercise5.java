package excercise;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Exercise5 extends BaseClass {

	@Test(priority = 2)
	void testClikLogin() {
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
	}

	@Test(priority = 3)
	void testSignUpDisplay() {
		driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
	}

	@Test(priority = 4)
	void enterData() {
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Princy");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("princy@gmail.com");
	}

	@Test(priority = 5)
	void clickSignupBtn() {
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
	}

	@Test(priority = 6)
	void verifyText() {
		boolean istextdisplay = driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']"))
				.isDisplayed();
		System.out.println(istextdisplay);
	}

}
