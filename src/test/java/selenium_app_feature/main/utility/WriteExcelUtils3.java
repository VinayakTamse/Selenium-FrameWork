package selenium_app_feature.main.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUtils3 {
	
	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(".\\src\\test\\resources\\writeexcel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data3");
		ArrayList<Object[]> lists = new ArrayList<Object[]>();
		lists.add(new Object[] {"EmpName", "EmpPlace", "EmpSalary"});
		lists.add(new Object[] {"Vinayak", "Bangalore", "90000"});
		lists.add(new Object[] {"Rajan", "Mumbai", "67000"});
		lists.add(new Object[] {"Karan", "Mumbai", "44000"});
		
		int rowCount = 0;
		
		for (Object [] obj : lists)
		{
			XSSFRow row = sheet.createRow(rowCount++);
			int cellCount = 0;
			
			for (Object c : obj)
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
		System.out.println("Completed");
		
	}

}
