package selenium_app_feature.main.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Interactions {
	
	WebDriverWait wait;
	
	public void typeTextbox(WebDriver driver, String locatorType, String locator, String value)
	{
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		if (locatorType.equalsIgnoreCase("xpath"))
		{
			WebElement xpathEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			js.executeScript("arguments[0].setAttribute('style', 'border : 2px dotted black;');", xpathEle);
			xpathEle.sendKeys(value);
		}
		
		else if (locatorType.equalsIgnoreCase("css"))
		{
			WebElement cssEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			js.executeScript("arguments[0].setAttribute('style', 'border : 2px dotted black;');", cssEle);
			cssEle.sendKeys(value);
			
		}
	}
	
	public void javascriptAction(WebDriver driver, String locatorType, String locator)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		switch (locatorType)
		{
		case "id" -> {
			js.executeScript("let x = document.getElementById('"+locator+"'); x.style.border='4px dotted black'; x.click();");
			
		}
		case "css" -> {
			js.executeScript("let x = document.querySelector('"+locator+"'); x.style.border='4px dotted black'; x.click();");
		}
		
		default -> {
			System.out.println("invalid");
		}
		}
	}
	

}
