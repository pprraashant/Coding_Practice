package com;
public class StringSplit{
	
	public static void main(String[]args)
	{
		String substring="acda";
		String MainString="wasdfasdacdawewfwaCdaAcda";
		MainString=MainString.toLowerCase();
		System.out.println(MainString);
		System.out.println(MainString.length());
		int count=0;
		for(String splits : MainString.split(substring))
		{
			System.out.println(splits);
			System.out.println(splits.length());
			count++;
		}
				System.out.println(count);
				//return count;
				//Class c= new Class();
	}
}