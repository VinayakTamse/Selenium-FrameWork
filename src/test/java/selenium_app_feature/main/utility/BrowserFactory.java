package selenium_app_feature.main.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	private static String chromedriverpath = ".\\src\\test\\resources\\drivers\\chromedriver.exe";
	private static String firefoxdriverpath = ".\\src\\test\\resources\\drivers\\geckodriver.exe";
	private static String edgedriverpath = ".\\src\\test\\resources\\drivers\\msedgedriver.exe";

	public static WebDriver BrowserType(String browser) throws Exception {
		WebDriver driver = null;

		switch (browser) {
			case "Chrome", "chrome" -> {
				System.setProperty("webdriver.chrome.driver", chromedriverpath);
				driver = new ChromeDriver();
			}
			case "Firefox", "firefox" -> {
				System.setProperty("webdriver.gecko.driver", firefoxdriverpath);
				driver = new FirefoxDriver();
			}
			case "Edge", "edge" -> {
				System.setProperty("webdriver.edge.driver", edgedriverpath);
				driver = new EdgeDriver();
			}
			default -> {
				throw new Exception("Invalid Browser Type Please Select Either Chrome, Firefox or Edge");
			}
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

}
