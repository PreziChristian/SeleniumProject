package selexamples;

import org.openqa.selenium.chrome.ChromeDriver;

public class SecondExample {
	ChromeDriver driver;
	String url="https://www.amazon.in/";
	public static void main(String[] args) throws InterruptedException {
		SecondExample s=new SecondExample();
		s.openWindow();
	}
	void openWindow() throws InterruptedException {
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();
	}

}
