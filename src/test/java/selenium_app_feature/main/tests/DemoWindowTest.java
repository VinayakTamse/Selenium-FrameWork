package selenium_app_feature.main.tests;

import java.util.Iterator;
import java.util.Set;
import org.testng.annotations.Test;

import selenium_app_feature.main.base.Css;
import selenium_app_feature.main.base.Main;
import selenium_app_feature.main.utility.Interactions;

public class DemoWindowTest extends Main {
	
	Interactions interact;
	
	@Test(priority=0, enabled=false)
	public void test_windows() throws Exception
	{
		launchBrowser();
		launchApp();
		
		interact = new Interactions();
		interact.javascriptAction(driver, "css", newWindowCss);
		
		Css.hault();
		
		Set<String> windowsId = driver.getWindowHandles();
		System.out.println("No of windows : "+windowsId.size());
		String mainWindow = driver.getWindowHandle();
		Iterator<String> winItr = windowsId.iterator();
		while (winItr.hasNext())
		{
			String childWin = winItr.next();
			if (!childWin.equals(mainWindow))
			{
				driver.switchTo().window(childWin);
				driver.manage().window().maximize();
				driver.close();
			}
		}
		
		driver.switchTo().window(mainWindow);
		
		
		Css.hault();
		closeBrowser();
		
	}
	
	@Test(priority=1, enabled=false)
	public void test_window2() throws Exception
	{
		launchBrowser();
		launchApp();
		
		interact = new Interactions();
		interact.javascriptAction(driver, "css", newWindowCss);
		
		timer();
		String mainwindow = driver.getWindowHandle();
		Set<String> windowsIds = driver.getWindowHandles();
		windowsIds.stream().filter(e -> !e.equals(mainwindow)).forEach(e -> {
			driver.switchTo().window(e);
			driver.manage().window().maximize();
			driver.close();
			
			
			
		});
	
		driver.switchTo().window(mainwindow);
		Css.hault();
		closeBrowser();
	}
	
	@Test(priority=2, enabled=true)
	public void test_window3() throws Exception
	{
		launchBrowser();
		launchApp();
		
		interact = new Interactions();
		interact.javascriptAction(driver, "css", newWindowCss);
		interact.javascriptAction(driver, "id", newwindowmsgId);
		Css.hault();
		String mainwindow = driver.getWindowHandle();
		Set<String> windowsId = driver.getWindowHandles();
		System.out.println(windowsId.size());
		Css.hault();
		windowsId.stream().skip(1).forEach(e -> {
			driver.switchTo().window(e);
			System.out.println(driver.getCurrentUrl());
			driver.close();
		});
		
		Css.hault();
		driver.switchTo().window(mainwindow);
	
		closeBrowser();
		
	}

}
