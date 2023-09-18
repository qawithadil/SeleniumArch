package excelOps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import base.Utilities;

public class WriteData {
	public static WebDriver driver;
	static Utilities ut;
	static int rowNum, ColNum;

	public static void main(String[] args) throws InvalidFormatException, IOException {
		WriteData(6, 0, "test6");
		WriteData(6, 1, "11222111");

	}

	private static void WriteData(int r1, int c1, String data) throws InvalidFormatException, IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\DataFiles\\Login.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		String sheetName = wb.getSheetName(0);
		XSSFSheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		XSSFRow row = sh.getRow(lastRow);
		XSSFCell cell = row.createCell(c1);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		System.out.println("Data has been Successfully Updated in Excel");
		wb.close();
		fis.close();
		wb.close();

	}

}
