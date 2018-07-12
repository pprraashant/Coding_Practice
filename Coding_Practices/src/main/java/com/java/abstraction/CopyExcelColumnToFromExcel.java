package com.java.abstraction;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CopyExcelColumnToFromExcel {
	
	public static void main(String [] args)
	{
		
	String path=System.getProperty("user.dir");
		String dataSheet = path+"//data//Adobe//HRALIRUMobile.xlsx";	
		
		String dataSheetWR = path+"//data//Adobe//DesktopNewClick2StoreConsumer.xlsx";
		
		System.out.println(dataSheet);
		try{
	
	
		
			ExcelOpener act= new ExcelOpener(dataSheet,dataSheetWR);
			act.open();
			//act.insertNewColumnBefore(1, 2);
			act.close();
			
			
			//Create the FileInputStream object			
				FileInputStream file = new FileInputStream(new File(dataSheet));
				FileInputStream FiletoWrite = new FileInputStream(new File(dataSheetWR));	
				//Get the workbook instance for XLS file 
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFWorkbook workbookWrite = new XSSFWorkbook(FiletoWrite);
				
				CellStyle style1 = workbook.createCellStyle();
				style1.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				//style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				style1.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
				style1.setBorderBottom((short) 1);
				style1.setBottomBorderColor(IndexedColors.WHITE.getIndex());
				style1.setBorderTop((short) 1);
				style1.setTopBorderColor(IndexedColors.WHITE.getIndex());
				style1.setBorderLeft((short) 1);
				style1.setLeftBorderColor(IndexedColors.WHITE.getIndex());
				style1.setBorderRight((short) 1);
				style1.setRightBorderColor(IndexedColors.WHITE.getIndex());
				
				CellStyle style2 = workbook.createCellStyle();
				style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				style2.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
				
				style2.setBorderBottom((short) 1);
				style2.setBottomBorderColor(IndexedColors.WHITE.getIndex());
				style2.setBorderTop((short) 1);
				style2.setTopBorderColor(IndexedColors.WHITE.getIndex());
				style2.setBorderLeft((short) 1);
				style2.setLeftBorderColor(IndexedColors.WHITE.getIndex());
				style2.setBorderRight((short) 1);
				
				
				Sheet sheet=workbook.getSheet("systemEvent");
				Sheet sheetWrite=workbookWrite.getSheet("systemEvent");
				System.out.println(sheet.getLeftCol());
				for(int i=0;i<85;i++)
				{
				Row row = sheet.getRow(i);
				Row rowWrite = sheet.getRow(i);
				System.out.println(row.getCell(2));
				ExcelOpener.cloneCell(rowWrite.getCell(2),row.getCell(2));
				ExcelOpener.writeToFile(workbookWrite, dataSheetWR);
				}
				
			
			}
		catch(Exception e)
		{
			System.out.println(""+e);
		}

}
}
