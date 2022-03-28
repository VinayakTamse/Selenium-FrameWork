package selenium_app_feature.main.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import selenium_app_feature.main.utility.BrowserFactory;

public class Main implements Xpath, Css {
	
	public static FileInputStream file;
	public static Properties props;
	private final String propertyFile = ".\\src\\test\\resources\\app.properties";
	public static WebDriver driver;
	static Main main;
	
	public Main()
	{
		try {
			file = new FileInputStream(propertyFile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		props = new Properties();
		try {
			props.load(file);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public static void launchBrowser() throws Exception
	{
		//main = new Main();
		driver = BrowserFactory.BrowserType(props.getProperty("Browser"));
	}
	
	public static void launchApp()
	{
		driver.get(props.getProperty("Url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	public static void timer()
	{
		Css.hault();
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}

}
