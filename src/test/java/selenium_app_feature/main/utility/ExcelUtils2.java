package selenium_app_feature.main.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils2 {
	
	public static void main(String[] args) throws Exception  {
		File f = new File(".\\src\\test\\resources\\testdata.xlsx");
		FileInputStream fileInput = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i=1; i<rows; i++)
		{
			for (int j=0; j<cols; j++)
			{
				String values = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(values+"   ");
			}
			System.out.println("");
		}
		workbook.close();
		fileInput.close();
	}

}
