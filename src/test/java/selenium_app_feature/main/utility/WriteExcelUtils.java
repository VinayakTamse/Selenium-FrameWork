package selenium_app_feature.main.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUtils {
	
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
		
		int row = ob.length;
		int col = ob[0].length;
		
		for (int i=0; i<row; i++)
		{
			XSSFRow rows = sheet.createRow(i);
			for (int j=0; j<col; j++)
			{
				XSSFCell cell = rows.createCell(j);
				Object value = ob[i][j];
				if (value instanceof String)
				{
					cell.setCellValue((String)value);
				}
				if (value instanceof Integer)
				{
					cell.setCellValue((Integer)value);
				}
				if (value instanceof Boolean)
				{
					cell.setCellValue((Boolean)value);
				}
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("Done");
		
	}

}
