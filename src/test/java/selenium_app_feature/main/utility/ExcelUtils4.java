package selenium_app_feature.main.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils4 {

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
				
				DataFormatter format = new DataFormatter();
				String value = format.formatCellValue(cell);
				System.out.print(value + "  ");
				
				
			}
			System.out.println("");
			
			
		}
	}
	
}
