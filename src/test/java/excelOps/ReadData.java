package excelOps;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import base.Utilities;

public class ReadData {
	public static WebDriver driver;
	static Utilities ut;
	static int rowNum, ColNum;

	public static void main(String[] args) throws InvalidFormatException, IOException {

		/*
		 * Calling Read Data Function - First Row (UserName, Password)
		 */
		String userName = ReadSingleData(1, 0);
		System.out.println("Username=" + userName);
		String password = ReadSingleData(1, 1);
		System.out.println("Password=" + password);

		/*
		 * Get Single  Column Data Values 
		 */
		getSingleColumn();
	}

	private static String ReadSingleData(int rowNum, int colNum) throws InvalidFormatException, IOException {

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\DataFiles\\Login.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet("sheet1");
		XSSFRow row = sh.getRow(rowNum);
		String data = row.getCell(colNum).toString();
		return data;

	}

	private static void getSingleColumn() throws InvalidFormatException, IOException {

		String dataArray[];
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\DataFiles\\Login.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		String sheetName = wb.getSheetName(0);
		XSSFSheet sh = wb.getSheet(sheetName);
		int LastRow = sh.getLastRowNum();
		dataArray = new String[LastRow];
		for (int i = 0; i < LastRow; i++) {
			XSSFRow row = sh.getRow(i);
			String data = row.getCell(0).toString();
			dataArray[i] = data;
		}
		System.out.println("******** Data in Column ************");

		for (int n = 1; n < dataArray.length; n++) {
			System.out.println(dataArray[n]);
		}

	}

}
