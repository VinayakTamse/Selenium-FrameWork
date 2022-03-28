package selenium_app_feature.main.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootPopped;
import org.testng.annotations.Test;

import selenium_app_feature.main.base.Main;

public class ShdowDomElement extends Main {
	
	
	@Test
	public void test_handle_shadowDomElement() throws Exception
	{
		launchBrowser();
		launchApp();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement bookApp = driver.findElement(By.tagName("book-app"));
		SearchContext shadowRoot1  = bookApp.getShadowRoot();
		
		//SearchContext shadowRoot1 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", bookApp);
		
		WebElement appHeader = shadowRoot1.findElement(By.cssSelector("app-header"));
		WebElement ele2 = appHeader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
		WebElement ele3 = ele2.findElement(By.tagName("book-input-decorator"));
		ele3.findElement(By.cssSelector("input#input")).sendKeys("Hello World");
		Thread.sleep(5000);
		closeBrowser();
		
		
	}
	

}
