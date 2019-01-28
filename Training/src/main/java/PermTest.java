public class PermTest {

	static int length1 = 1;
	public static String[] S;
public static void main(String[] args) throws Exception {
    String str = "acdaa";
    StringBuffer strBuf = new StringBuffer(str);
    
    int length = str.length();
    //static int length1 = 1;
    while (length > 0)
    {
    length1 = length1 * length ;
    length = length -1;
    }
    doPerm(strBuf,str.length());
  
    for(int i=0;i<length1;i++)
    {
    	System.out.println(S[i]);
    }

}

private static void doPerm(StringBuffer str, int index){
 S= new String[length1];
    if(index <= 0)
    {
    	Boolean match=true;
        
        for(int i=0;i<length1;i++)
        {
        	for(int j=0;j<length1;j++)
        	{
        		String s1=new String(str);
        		//System.out.println(s1);
        		if(s1.equals(S[j]))
        		{
        			break;
        		}
        		S[i]= new String(str);
        		
        	}
        }
        if(match)
        	System.out.println();
        	//System.out.println(str);
    }
    
    else { //recursively solve this by placing all other chars at current first pos
        doPerm(str, index-1);
        int currPos = str.length()-index;
        for (int i = currPos+1; i < str.length(); i++) {//start swapping all other chars with current first char
            swap(str,currPos, i);
            doPerm(str, index-1);
            swap(str,i, currPos);//restore back my string buffer
        }
    }
}

private  static void swap(StringBuffer str, int pos1, int pos2){
    char t1 = str.charAt(pos1);
    str.setCharAt(pos1, str.charAt(pos2));
    str.setCharAt(pos2, t1);
} 
} 