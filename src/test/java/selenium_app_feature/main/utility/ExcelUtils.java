package selenium_app_feature.main.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static void main(String[] args) throws IOException {
		File f = new File(".\\src\\test\\resources\\testdata.xlsx");
		FileInputStream fileInput = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator itr = sheet.iterator();
		while (itr.hasNext())
		{
			XSSFRow rowItr = (XSSFRow)itr.next();
			Iterator cellItr = rowItr.cellIterator();
			
			while (cellItr.hasNext())
			{
				XSSFCell cell = (XSSFCell)cellItr.next();
				switch(cell.getCellType())
				{
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				}
				
				System.out.print("  |  ");
			}
			
			System.out.println();
			
		}
	}

}
