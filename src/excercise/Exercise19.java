package excercise;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Exercise19 extends BaseClass{

	@Test(priority=1)
	void clickProduct() {
		driver.findElement(By.xpath("//a[@href='/products']")).click();
	}
	
	@Test(priority=2)
	void verifyBrandDisplay() {
		System.out.println(driver.findElement(By.xpath("//h2[text()='Brands']")).isDisplayed());
	}
	@Test(priority=3)
	void clickOnBrand() {
		driver.findElement(By.xpath("//a[@href='/brand_products/Babyhug']")).click();
	}
	@Test(priority=4)
	void verifybrandDisplay() {
		System.out.println(driver.findElement(By.xpath("//h2[contains(.,'Babyhug')]")).isDisplayed());
	}
	@Test(priority=5)
	void clickOnAnotherBrand() {
		driver.findElement(By.xpath("//h2[contains(.,'Babyhug')]")).click();
	}
	void verifyAnotherBrand() {
		System.out.println(driver.findElement(By.xpath("//h2[contains(.,'Biba')]")).isDisplayed());
	}
	
}
