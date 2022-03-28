package selenium_app_feature.main.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityApp {
	
	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	String filepath;
	
	public ExcelUtilityApp(String filepath)
	{
		this.filepath = filepath;
	}
	
	public  void setExcelData(String sheetname, int rownum, int colnum, String data) throws IOException
	{
		File file = new File(filepath);
		if (!file.exists())
		{
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(filepath);
			workbook.write(fo);
		}
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook();
		
		if (workbook.getSheetIndex(sheetname)==-1)
		{
			workbook.createSheet(sheetname);
		}
		
		sheet = workbook.getSheet(sheetname);
		if (sheet.getRow(rownum)==null)
		{
			sheet.createRow(rownum);
		}
		row = sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		
		cell.setCellValue(data);
		
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

}
