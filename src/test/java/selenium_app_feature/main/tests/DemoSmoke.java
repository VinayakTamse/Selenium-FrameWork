package selenium_app_feature.main.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium_app_feature.main.base.Main;
import selenium_app_feature.main.utility.Interactions;

public class DemoSmoke extends Main {
	
	Interactions interact;
	
	@BeforeMethod
	public void setUp()
	{
		interact = new Interactions();
	}
	
	@Test(priority=0)
	public void test_01_xpath() throws Exception
	{
		launchBrowser();
		launchApp();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		interact.typeTextbox(driver, "xpath", usernameXpath, "Admin");
		interact.typeTextbox(driver, "xpath", passwordXpath, "admin123");
		interact.javascriptAction(driver, "id", loginBtnId);
		closeBrowser();
	}
	
	@Test(priority=1)
	public void test_01_css() throws Exception 
	{
		launchBrowser();
		launchApp();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		interact.typeTextbox(driver, "css", usernameCss, "Admin");
		interact.typeTextbox(driver, "css", passwordCss, "admin123");
		interact.javascriptAction(driver, "css", loginButtonCss);
		closeBrowser();
	}

}
