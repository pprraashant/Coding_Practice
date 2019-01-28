package practices;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelColRead
{
	public static void main(String [] args) throws BiffException, IOException
	{
	String workingDir = System.getProperty("user.dir");
	 String FilePath = workingDir+"\\data\\TestData.xls";
	 HashMap <String, String> DataRepository = new HashMap<String, String>();
	 
	 Workbook workbook = Workbook.getWorkbook(new File(FilePath));
		Sheet sheet = workbook.getSheet(0);
		System.out.println(sheet.getCell(1, 0).getContents().isEmpty());
		for(int i=0;!sheet.getCell(0, i).getContents().isEmpty(); i++)
		{
			System.out.println("Hey"+sheet.getCell(0, i).getContents());
			DataRepository.put(sheet.getCell(0, i).getContents(),sheet.getCell(0, i).getContents());
		}
	}
}