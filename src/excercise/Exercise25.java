package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Exercise25 extends BaseClass{

	@Test(priority=1)
	void scrollPage() {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		
	}
	
	@Test(priority=2)
	void verifySubsription() {
		System.out.println("Display:"+driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());
	}
	@Test(priority=3)
	void clickArrow() {
		driver.findElement(By.xpath("//a[@id='scrollUp']")).click();
	}
	@Test(priority=4)
	void verifyText() {
		driver.findElement(By.xpath("(//h2[contains(text(),'Full-Fledged')])[1]")).isDisplayed();
	}
}
