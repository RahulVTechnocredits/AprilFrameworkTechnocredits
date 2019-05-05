package testScripts;

import org.openqa.selenium.WebDriver;

import base.PredefinedActions;


public class TestBase {
	private WebDriver driver;
	
	void start()  {
		driver =PredefinedActions.initialization("https://demo.borland.com/gmopost/");
	}
	
	void close()  {
		driver=PredefinedActions.closeBrowser();
	}
	void back() {
		driver.navigate().back();
	}
}
