package com.qa.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws Throwable {
		//File file=new File("./data/sample.xlsx");
		String filepath="./data/sample.xlsx";
		XSSFWorkbook wbook= new XSSFWorkbook();
		XSSFSheet sheet = wbook.createSheet("info");

		Object [][] empData= {
								{"empId","name","job"},
								{123,"kal","ENG"},
								{124,"moh","IT"},
								{125,"saf","MECH"},
							 };

		int rowCount=empData.length;
		int colCount=empData[0].length;
		
		System.out.println(rowCount);
		System.out.println(colCount);
		
		for (int r = 0; r < rowCount; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < colCount; c++) {
				XSSFCell cell = row.createCell(c);
				Object value=empData[r][c];
				
				if (value instanceof String) {
					cell.setCellValue((String)value);
				}else if (value instanceof Integer) {
					cell.setCellValue((Integer)value);
				}else if(value instanceof Boolean) {
					cell.setCellValue((Boolean)value);
				}
}
			
		}
		
		FileOutputStream fo= new FileOutputStream(filepath);
		wbook.write(fo);
		wbook.close();
		
	}

}
