package selenium_app_feature.main.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcelUtils {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getLastRowNum() + 1;
		int cols = sheet.getRow(0).getLastCellNum();
		workbook.close();
		file.close();
		Object [][] data = new Object[][] {
			{"Jaison", "Pune", 29000}
		};
		FileOutputStream fio = new FileOutputStream(".\\src\\test\\resources\\testdata.xlsx");
		XSSFWorkbook wrk = new XSSFWorkbook();
		XSSFSheet sh = wrk.createSheet("app");
		int r = data.length;
		int c = data[0].length;
		for (int i=rows; i<r; i++)
		{
			XSSFRow row1 = sh.createRow(i);
			
			for (int j=0; j<c; j++)
			{
				XSSFCell cellValue = row1.createCell(j);
				Object value = data[i][j];
				if (value instanceof String str)
				{
					cellValue.setCellValue(str);
				}
				if (value instanceof Integer num)
				{
					cellValue.setCellValue(num);
				}
				if (value instanceof Boolean tf)
				{
					cellValue.setCellValue(tf);
				}
			}
		}
		wrk.write(fio);
		fio.close();
		System.out.println("Completed");
		
	}
	
	

}
