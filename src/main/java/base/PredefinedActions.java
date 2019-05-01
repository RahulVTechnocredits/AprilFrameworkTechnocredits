package base;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import constant.ConstantPath;
import customExceptions.ElementNotEnabledException;

public class PredefinedActions {

	static WebDriver driver;

	
	public static void initialization(String url) {

		System.setProperty("webdriver.chrome.driver", ConstantPath.CHROMEDRIVERexe);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}
	public static void closeBrowser() {

		driver.quit();

	}
	

	protected WebElement getElement(String locator) {

		String locatorType = locator.split(":-")[0].replace("[", "").replace("]", "");
		String locatorValue = locator.split(":-")[1];

		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locatorType.toUpperCase()) {
		case "ID":

			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));

		case "XPATH":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));

		case "NAME":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));

		default:
			return null;

		}

	}
	
	protected List<String> getTableElements(String locator){
		
		String locatorType = locator.split(":-")[0].replace("[", "").replace("]", "");
		String locatorValue = locator.split(":-")[1];
		ArrayList<String>al= new ArrayList<String>();
		
		int size= driver.findElements(By.xpath(locatorValue+"/td/a")).size();
		System.out.println("Count of Items: "+size);
		
		for (int i = 2; i <= size+1; i++) {
			
			String itemName = driver.findElement(By.xpath(locatorValue+"[" + i + "]/td/a")).getText();
			
			al.add(itemName);
			
		}
		
		//table/tbody/tr/td/a
	//table/tbody/tr[2]/td/a
		
		return al;
		
	}

	private void setBorderVisibilty(WebElement element, boolean flag) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (flag) {
			js.executeScript("argument[0].style.border='3px red solid'", element);
		} else
			js.executeScript("argument[0].style.border='0px red solid'", element);

	}

	protected void click(String locator) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	//	setBorderVisibilty(element, false);
		element.click();

	}

	
	
	protected void setText(String locator, String value) {
		WebElement element = getElement(locator);
		if (element.isEnabled()) {
			element.sendKeys(value);

		} else {
			throw new ElementNotEnabledException(locator + " is not enabled");
		}

	}

	protected  String getText(String locator ) {
		WebElement element = getElement(locator);
		String actualString =element.getText();
		return actualString;
	}
	
	protected  String getValue(String locator ) {
		WebElement element = getElement(locator);
		String actualValue=element.getAttribute("value");
		return actualValue;
	}
	
	
	
	
	protected String getPageTitle() {
		return driver.getTitle();
	}

	protected String getPageURL() {
		return driver.getCurrentUrl();
	}

	public boolean visibilityOfElement(String locator) {
		WebElement element = null;
		try {
			element = getElement(locator);
			return element.isDisplayed();
		}

		catch (NoSuchElementException ne) {
			return false;
		}

	}
	public boolean ClickableElement(String locator) {
		WebElement element = null;
		try {
			element = getElement(locator);
			return element.isEnabled();
		}

		catch (NoSuchElementException ne) {
			return false;
		}

	}

	
	protected String acceptAlert() {
		Alert alert =driver.switchTo().alert();
		String actual=alert.getText();
		alert.accept();
		return actual;
	}
}