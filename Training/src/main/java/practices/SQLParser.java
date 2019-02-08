package practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class SQLParser {

	public static void main(String[] args) throws IOException {

		int noofrows = 0, noofconditions = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		// System.out.println(input.length());
		String[] splitstring = input.split(",");
		for (int i = 0; i < splitstring.length; i++) {
			if (i == 0) {
				noofrows = Integer.parseInt(splitstring[i]);
			} else {
				noofconditions = Integer.parseInt(splitstring[i]);
			}
		}

		String input1 = br.readLine();

		String input2 = null;
		String[] header = input1.split(",");
		String[][] rows = new String[noofrows][header.length];
		for (int i = 0; i < noofrows; i++) 
		{
			input2 = br.readLine();
			String sliparr[] = input2.split(",");

			for (int ii = 0; ii < sliparr.length; ii++) 
			{
				rows[i][ii] = sliparr[ii];
			}
		}
		String conditions[] = new String[noofconditions];
		for (int i = 0; i < noofconditions; i++) 
		{
			conditions[i] = br.readLine();

		}
		HashMap<String,String> condition=new HashMap<String, String>();
		String cond []=conditions[0].split("[<>=]");
		System.out.println(cond[0]);
		condition.put(cond[0], cond[1]);
		System.out.println(""+condition.get(cond[0]));
		
		//solutions to find out the now of rows
		
		for (int i = 0; i < noofrows; i++) 
		{
			for(int j=0;j<header.length;j++)
			{
				
			}
		}
	}
}
