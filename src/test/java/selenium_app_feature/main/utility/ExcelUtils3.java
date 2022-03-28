package selenium_app_feature.main.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils3 {
	
	public static void main(String[] args) throws Exception {
		
		File f = new File(".\\src\\test\\resources\\testdata.xlsx");
		FileInputStream fileInput = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		for (int i=0; i<=row; i++)
		{
			for (int j=0; j<col; j++)
			{
				XSSFCell cellvalue = sheet.getRow(i).getCell(j);
				DataFormatter format = new DataFormatter();
				String value = format.formatCellValue(cellvalue);
				System.out.print(value+"   |   ");
				
			}
			
			System.out.println("");
		}
		
	}

}
