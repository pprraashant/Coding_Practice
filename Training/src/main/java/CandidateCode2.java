import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CandidateCode2
{
 
	   public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        int output = 0;
	        int ip1_rows = 0;
	        int ip1_cols = 0;
	        ip1_rows = Integer.parseInt(in.nextLine().trim());
	        ip1_cols = Integer.parseInt(in.nextLine().trim());
	        
	        int[][] ip1 = new int[ip1_rows][ip1_cols];
	        for(int ip1_i=0; ip1_i<ip1_rows; ip1_i++) {
	            for(int ip1_j=0; ip1_j<ip1_cols; ip1_j++) {
	                ip1[ip1_i][ip1_j] = in.nextInt();
	                
	            }
	        }
	        output = SolveMagicSquare(ip1);
	        System.out.println(String.valueOf(output));
	    }
	
	    public static int SolveMagicSquare(int[][] input1)
	    {
	    	boolean result=false;
	    	for(int i=0;i<input1[0].length;i++)
	    	{
	    		for(int k=0;k<input1.length;k++)
    			{
	    			if((i+1)<input1.length)
	    			{
	    					if(input1[i][k]==input1[i+1][k])
	    					{
			    			result=true;
			    			break;
	    					}
	    			}
		    		
	    		}
			
	    }
	    	return result ? 1 : 0;
	    }


}
