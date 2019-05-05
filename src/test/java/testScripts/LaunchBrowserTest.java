package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowserTest {

	@Test
	public void LaumchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
		
	}
}
