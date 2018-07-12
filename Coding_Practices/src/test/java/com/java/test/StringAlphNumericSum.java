package com.java.test;

public class StringAlphNumericSum {
	
	int sumOfNumericinString(String alphanumeric)
	{
		char[] chararray=alphanumeric.toCharArray();
		
		String cntnum="";
		Character [] characterarray = new Character[alphanumeric.length()];
		
		for(int i=0;i<chararray.length;i++)
		{
			characterarray[i]=alphanumeric.charAt(i);
		}
		for(int i=0;i<chararray.length;i++)
		{
			if(Character.isDigit(chararray[i]))
			{
				while(Character.isDigit(chararray[i++]))
				{
					System.out.println(chararray[i]);
					if(i<=alphanumeric.length())
						break;
					System.out.println(chararray[i]);
					cntnum=cntnum+chararray[i];
				}
				System.out.println(cntnum);
			}
		}
		
		
		return 0;
	}

	public static void main(String [] args)
	{
		StringAlphNumericSum sk=new StringAlphNumericSum();
		System.out.println(sk.sumOfNumericinString("aa143ba9"));
	}
}
