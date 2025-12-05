package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise7 extends BaseClass{

	WebDriver driver;
	
	@Test(priority=2)
	void clickTestCase() {
		driver.findElement(By.xpath("//a[normalize-space()='Test Cases']")).click();
	}
	
	@Test(priority=3)
	void testTestCasesPage() {
		String currentUrl= driver.getCurrentUrl();
		String expectUrl="https://automationexercise.com/test_cases";
		Assert.assertEquals(expectUrl, currentUrl);
		System.out.println("It's Test case Page");
	}
	
}
