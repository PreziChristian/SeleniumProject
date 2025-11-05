package selexamples;

import org.openqa.selenium.chrome.ChromeDriver;

interface Demo{
	String url="https://www.amazon.in/";
}

public class UsingInterface implements Demo {

	ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		UsingInterface obj=new UsingInterface();
		obj.demo();
	}

	
	public void demo() {
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		
	}

}
