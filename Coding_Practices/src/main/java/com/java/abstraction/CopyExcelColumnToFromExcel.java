package com.java.abstraction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CopyExcelColumnToFromExcel {
	
	public static void main(String [] args)
	{
		
	String path=System.getProperty("user.dir");
		String mainSheet = path+"//data//WirelessSalesRegression.xlsx";
		String dataSheet = path+"//data//Adobe//HRALIRUMobile.xlsx";	
		//String dataSheetWR = path+"//data//Adobe//DesktopNewClick2StoreConsumer.xlsx";
		
		
		try{
	
			
		
			
			
			//Create the FileInputStream object
				FileInputStream mainFile = new FileInputStream(new File(mainSheet));
				FileInputStream file = new FileInputStream(new File(dataSheet));
					
				//Get the workbook instance for XLS file 
				XSSFWorkbook workbookMain = new XSSFWorkbook(mainFile);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				
				
				Sheet sheetMain=workbookMain.getSheet("MAIN");
				int totalRowCount=sheetMain.getLastRowNum();
				for(int excelfile=1;excelfile<totalRowCount;excelfile++)
				{
					if(excelfile % 2 == 0)
					{
						Row rowMain = sheetMain.getRow(excelfile);
						System.out.println(rowMain.getCell(2));
						
						String dataSheetWR = path+"//data//Adobe//"+rowMain.getCell(2)+".xlsx";
						
						try
						{
						
						FileInputStream FiletoWrite = new FileInputStream(new File(dataSheetWR));
						
						
						XSSFWorkbook workbookWrite = new XSSFWorkbook(FiletoWrite);
						
						ExcelOpener act= new ExcelOpener(dataSheet,dataSheetWR);
						//act.open();
						//act.insertNewColumnBefore(1, 2);
						//act.close();
						
						
						Sheet sheet=workbook.getSheet("systemEvent");
						Sheet sheetWrite=workbookWrite.getSheet("systemEvent");
						
						for(int i=0;i<85;i++)
						{
						if(sheet!=null || sheetWrite!=null )
						{
						Row row = sheet.getRow(i);
						Row rowWrite = sheetWrite.getRow(i);
						System.out.println(row.getCell(2));
						ExcelOpener.cloneCell(workbookWrite,rowWrite.getCell(2),row.getCell(2));
						ExcelOpener.writeToFile(workbookWrite, dataSheetWR);
						}
						}
						}
						catch(FileNotFoundException e)
						{
							System.out.println(""+dataSheetWR+e);
						}
						
					}
					
				}
				
			
				
			
			}
		catch(Exception e)
		{
			System.out.println(""+e);
		}

}
}
