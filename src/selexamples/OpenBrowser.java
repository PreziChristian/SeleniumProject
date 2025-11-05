package selexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.HasDevTools;

public class OpenBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.programiz.com/");  
		Thread.sleep(2000);
		driver.quit();
		
		

	}
	
	

}
