package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1  extends BaseClass{
	
	@Test(priority = 2)
	void testClikLogin()  {
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
	}
	
	@Test(priority = 3)
	void testSignUpDisplay() {
		driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
	}
	
	@Test(priority = 4)
	void enterData() {
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Prince12");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("princechri@gmail.com");
	}
	@Test(priority = 5)
	void clickSignupBtn() {
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
	}
	
	@Test(priority=6)
	void verifyText() {
		driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();
	}

	@Test(priority=7)
	void fillData() {
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		WebElement list = driver.findElement(By.xpath("//select[@id='days']"));
		list.click();
		list.findElement(By.xpath("//option[text()='16']")).click();
		
		WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
		month.click();
		month.findElement(By.xpath("//option[normalize-space()='March']")).click();
		
		WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
		year.click();
		year.findElement(By.xpath("//option[@value='2020']")).click();
		
		
		
		
	}
	@Test(priority=8)
	void clickNewsletter() {
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
	}
	@Test(priority=9)
	void clickOffer() {
		driver.findElement(By.xpath("//input[@id='optin']")).click();
	}
	
	@Test(priority=10)
	void enterAddressData() {
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Prezi");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Christian");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Byte long");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Rajendra park");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Odhav");
		
		driver.findElement(By.xpath("//select[@id='country']")).click();
		driver.findElement(By.xpath("//option[@value='United States']")).click();
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("gujarat");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Ahmedabad");
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("122456");
		driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1234567898");
		
	}
	
	@Test(priority=11)
	void clickAccountbtn() {
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
	}
	
	@Test(priority=12)
	void testcreatedDisplay() {
		driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed();
	}
	
	@Test(priority=13)
	void clickContinue() {
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
	}
	@Test(priority=14)
	void verifyLoinText() {
		driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]")).isDisplayed();
	}
	
	@Test(priority=15)
	void clickDelete() {
		driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
	}
	@Test(priority=16)
	void verifyDeleteAcc() throws InterruptedException {
		driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		
	}
	
}
