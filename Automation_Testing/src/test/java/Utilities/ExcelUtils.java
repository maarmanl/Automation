package Utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static String path;
	
	public ExcelUtils(String excelPath, String sheetName) {
		
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			 sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getCellData(int rowNum, int columnNum) {
	
		String cellData = sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
	}
}
