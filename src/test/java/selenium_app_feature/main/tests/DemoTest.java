package selenium_app_feature.main.tests;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import selenium_app_feature.main.base.Css;
import selenium_app_feature.main.base.Main;

public class DemoTest extends Main {
	
	
	@Test
	public void test_app1() throws Exception
	{
		launchBrowser();
		launchApp();
		Css.hault();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		Css.hault();
		closeBrowser();
	}
	
	@Test
	public void test_app2() throws Exception
	{
		launchBrowser();
		launchApp();
		Css.hault();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com/");
		Css.hault();
		closeBrowser();
	}

}
