package selenium_app_feature.main.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium_app_feature.main.base.Main;
import selenium_app_feature.main.utility.ExcelUtilityApp;

public class TabelExamples extends Main {
	
	
	
	@Test
	public void test_tables() throws Exception
	{
		launchBrowser();
		launchApp();
		
		List<List<Object>> arrLists = new ArrayList<List<Object>>();
		List<Object> lis = new ArrayList<Object>();
		String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdatademo.xlsx";
		ExcelUtilityApp app1 = new ExcelUtilityApp(filepath);
		WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", table);
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']/child::tbody/tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='customers']/child::tbody/tr[1]/*")).size();
		System.out.println(rowCount);
		
		for (int i=2; i<=rowCount; i++) 
		{
			for (int j=1; j<=colCount; j++)
			{
				String value = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText();
				lis.add(value);
			}
			
		}
		
		List<Object> obj1 = lis.subList(0, 3);
		List<Object> obj2 = lis.subList(3, 6);
		List<Object> obj3 = lis.subList(6, 9);
		List<Object> obj4 = lis.subList(9, 12);
		List<Object> obj5 = lis.subList(12, 15);
		List<Object> obj6 = lis.subList(15, 18);
		arrLists.add(obj1);
		arrLists.add(obj2);
		arrLists.add(obj3);
		arrLists.add(obj4);
		arrLists.add(obj5);
		arrLists.add(obj6);
		System.out.println(arrLists);
		
	
		
	
	}

}
