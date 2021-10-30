package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.base.TestBase;

public class XLUtility extends TestBase{

	public static String path;
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell col;
	public static FileOutputStream fo;
	public static FileInputStream fi;

	public XLUtility(String path) {
		this.path=path;
	}


	public static Object[][] readExcelData(String excelfileName)  {
		try {
			XSSFWorkbook wbook = 
					new XSSFWorkbook("./data/"+excelfileName+".xlsx");
			XSSFSheet sheet = wbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			System.out.println("Row Count is: "+rowCount);
			int colCount = sheet.getRow(0).getLastCellNum();
			System.out.println("Col Count is: "+colCount);
			data = new Object[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					XSSFCell cell = row.getCell(j);
					String stringCellValue = cell.getStringCellValue();
					data[i-1][j] = stringCellValue;
					System.out.println(stringCellValue);
				} 
			}
			wbook.close();

		} catch (Exception e) {		
			e.printStackTrace();
		}
		return data;
	}

	public void writeExcelData(String sheetName,int rowNum,int colNum,String data) throws Exception{

		File xlFile=new File(path);

		if(!xlFile.exists()) {
			wbook=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			wbook.write(fo);
		}
		fi=new FileInputStream(path);
		wbook=new XSSFWorkbook(fi);

		if (wbook.getSheetIndex(sheetName)==-1) {
			wbook.createSheet(sheetName);
		}
		sheet=wbook.getSheet(sheetName);

		if (sheet.getRow(rowNum)==null) {
			sheet.createRow(rowNum);
		}
		row=sheet.getRow(rowNum);

		cell=row.createCell(colNum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		wbook.write(fo);
		wbook.close();
		fi.close();
		fo.close();


















	}

}
