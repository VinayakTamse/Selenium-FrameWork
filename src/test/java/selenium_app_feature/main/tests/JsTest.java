package selenium_app_feature.main.tests;


import java.util.Arrays;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;



import selenium_app_feature.main.base.Css;
import selenium_app_feature.main.base.Main;

public class JsTest extends Main {
	
	@Test
	public void jsTest01() throws Exception
	{
		launchBrowser();
		launchApp();
		Css.hault();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object obj = js.executeScript("var t = []; var btnLists = document.getElementsByTagName('button'); var y = Array.from(btnLists); for (m of y){ t.push(m.innerText);} return t;");
		List<Object> l = Arrays.asList(obj);
		System.out.println(l.size());
		
		closeBrowser();
		
		
		
	}

}
