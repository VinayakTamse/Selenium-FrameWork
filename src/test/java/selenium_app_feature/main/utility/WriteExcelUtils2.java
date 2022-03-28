package selenium_app_feature.main.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUtils2 {
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(".\\src\\test\\resources\\writeexcel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		Object [][] ob = new Object [][] {
			{"EmpId", "EmpName", "EmpPlace"},
			{100, "Arun", "Mumbai"},
			{101, "Rajan", "Kerala"},
			{102, "Kalyan", "Chennai"},
			{103, "Naveen", "Bangalore"}
		};
		
		int rowCount = 0;
		for (Object [] r : ob)
		{
			XSSFRow row = sheet.createRow(rowCount++);
			
			int cellCount = 0;
			
			for (Object c : r)
			{
				XSSFCell cell = row.createCell(cellCount++);
				if (c instanceof String str)
				{
					cell.setCellValue(str);
				}
				if (c instanceof Integer num)
				{
					cell.setCellValue(num);
				}
				if (c instanceof Boolean tf)
				{
					cell.setCellValue(tf);
				}
			}
		}
		workbook.write(file);
		file.close();
	}

}
