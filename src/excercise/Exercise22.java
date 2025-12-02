package excercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise22 extends BaseClass {

	@Test(priority = 1)
	void scrollToBottom() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

	}

	@Test(priority = 2)
	void verifyRecommandText() {
		System.out.println("Display:" + driver.findElement(By.xpath("//h2[contains(.,'recommended')]")).isDisplayed());
		WebElement addToCartBtn = driver
				.findElement(By.xpath("//div[@class='item active']//a[contains(@class,'add-to-cart')]"));
		addToCartBtn.click();

	}

	@Test(priority = 3)
	void clickViewCart() {
		driver.findElement(By.xpath("//u[text()='View Cart']")).click();
	}

	@Test(priority = 4)
	void verifyAllProduct() {

		List<WebElement> productRows = driver
				.findElements(By.xpath("//table[@id='cart_info_table']//tr[contains(@id,'product-')]"));

		System.out.println("Total products = " + productRows.size());

		for (WebElement row : productRows) {
			String desc = row.findElement(By.cssSelector("td.cart_description")).getText();
			System.out.println(desc);

		}
	}

}
