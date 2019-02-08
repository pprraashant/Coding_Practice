import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CandidateCode
{
	

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1 = Integer.parseInt(in.nextLine().trim());
        int ip2 = Integer.parseInt(in.nextLine().trim());
        String ip3 = in.nextLine().trim();
        String ip4 = in.nextLine().trim();
        output = appearanceCount(ip1,ip2,ip3,ip4);
        System.out.println(String.valueOf(output));
    }
    
    public static int appearanceCount(int input1,int input2,String input3,String input4)
    {
    	int count=0;
    	input3=input3.toLowerCase();
    	input4=input4.toLowerCase();
    	char [] S =input3.toCharArray();
    	Arrays.sort(S);
    	String tomatch=new String(S);
    	for(int i=0;i<(input2-input1);i++)
    	{
    	
    		char [] W =input4.substring(i,(i+input1)).toCharArray();
    		Arrays.sort(W);
    		if(tomatch.equals(new String(W)))
    			{
    			count++;
    			}
    	}
    	return count;
    	/*
    	input3=input3.toLowerCase();
    	input4=input4.toLowerCase();
    	int lenghtofinput4=input4.length();
		int count=0;
		for(String splits : input4.split(input3))
		{
			count+=splits.length();
		}
		//System.out.println(count);
		return (lenghtofinput4-count)/input1;
		*/
		
	    
    }

}
