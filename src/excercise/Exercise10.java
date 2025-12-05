package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise10 extends BaseClass {

	WebDriver driver;

	@Test(priority = 2)
	void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement footer = driver.findElement(By.xpath("//div[@class='footer-widget']"));

		js.executeScript("arguments[0].scrollIntoView();", footer);
		// js.executeScript("arguments[0].scrollIntoView();", scrolltext);
	}

	@Test(priority = 3)
	void verifyTextSub() {
		boolean textDisplay = driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
		System.out.println(textDisplay);
	}

	@Test(priority = 4)
	void enterEmail() {

		driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("prezichristian@gamil.com");
		driver.findElement(By.xpath("//button[@id='subscribe']")).click();
	}

	@Test(priority = 5)
	void visblealert() {
		driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed();
	}

}
