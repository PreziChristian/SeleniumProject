package excercise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Exercise6 extends BaseClass {

	@Test(priority = 2)
	void clickContactUs() {
		driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();
	}

	@Test(priority = 3)
	void verifygetInTouchVisible() {
		boolean textVisible = driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed();
		System.out.println(textVisible);
	}

	@Test(priority = 4)
	void fillData() {
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Prezi");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("prezichristian@gamil.com");
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Demo");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Automation Testing");

	}

	@Test(priority = 5)
	void uploadfile() {
		String projectPath = System.getProperty("user.dir");
		String filepath=projectPath +"\\txt.txt";
		System.out.println(filepath);
		driver.findElement(By.xpath("//input[@name='upload_file']"))
				.sendKeys(filepath);
	}

	@Test(priority = 6)
	void clickSubmit() {
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}

	@Test(priority = 7)
	void switchToAlert() {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

	}

	@Test(priority = 8)
	void verifySuccessmsg() {
		boolean verifymsg = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed();
		System.out.println(verifymsg);
	}

	@Test(priority = 9)
	void clickonHome() {
		driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();

	}

}
