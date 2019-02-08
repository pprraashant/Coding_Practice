package com.java.test;

public class ReverseString {

	public static void main(String[] args) {
		
		
		
		// TODO Auto-generated method stub

		String sr= new String("Prashant");
		
		System.out.println(""+sr.length());
		System.out.println(sr);
		char c= '\0';
		
		String sr1= sr+c;
		System.out.println(""+sr1.length());
		System.out.println(sr1);
		int count=0;
		int bucket=100;
		for(int i=0;i<bucket;i++)
		{
			count++;
			if(sr1.charAt(i) =='\0' || sr1.charAt(i)==' ')
			{
				break;
			}
			if(bucket==100)
			{
				bucket=bucket+100;
			}
		}
		System.out.println(count);
		String rev = "";
		for(int i=count-1;i>=0;i--)
		{
			char temp=sr1.charAt(i);
			rev=rev+temp;
			
		}
		System.out.println("Reverse String: "+ rev+" Length is: "+rev.length());
		System.out.println("after trip reverse: "+rev.trim()+" Length is: "+rev.length());
	}

}
