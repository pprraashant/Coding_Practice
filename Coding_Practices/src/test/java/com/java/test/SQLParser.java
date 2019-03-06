package com.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SQLParser {
	
	public static void main(String [] args) throws IOException
	{
		
		int noofrows=0,noofconditions=0;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		//System.out.println(input.length());
		String [] splitstring=input.split(",");
		for(int i=0;i<splitstring.length;i++)
		{
			if(i==0)
			{
			noofrows=Integer.parseInt(splitstring[i]);
			}
			else
			{
				noofconditions=	Integer.parseInt(splitstring[i]);
			}
		}
		
		//System.out.println(noofrows+","+noofconditions);
	//String [] header=new String[noofrows];
		String input1=br.readLine();
		//System.out.println(input1.length());
		String input2=null;
		String [] header=input1.split(",");
		String [][]rows = null;
		for(int i=0;i<noofrows;i++)
		{
		input2=br.readLine();
		String sliparr[]=input2.split(",");
			for(int ii=0;ii<sliparr.length;ii++)
			{
				rows[i][ii]=sliparr[ii];
			}
		}
	String conditions[]=null;
		for(int i=0;i<noofconditions;i++)
		{
			String input3=br.readLine();
			
		}
	}
}
