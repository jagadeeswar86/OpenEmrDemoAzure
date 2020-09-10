package org.slk.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public static Object[][] getSheetObjArray(String fileLocation,String sheetName) throws IOException {

		FileInputStream file = new FileInputStream(fileLocation); //
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);//
		 int rowcount= sheet.getPhysicalNumberOfRows();
		 System.out.println("rowcount: " +rowcount);
		 
		 int cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		 System.out.println("cellcount: "+cellcount);
	     Object[][] main=new Object[rowcount-1][cellcount];

		for (int i =1; i < rowcount; i++) {
			System.out.println(i);
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cellcount; j++) 
			{
				XSSFCell cell = row.getCell(j);

				DataFormatter formate = new DataFormatter();

				String cellvalue = formate.formatCellValue(cell);

				System.out.println(cellvalue);
				
				main[i-1][j]=cellvalue;
              
			}
		}
		
		book.close();
		file.close();
		return main;
	}
}


