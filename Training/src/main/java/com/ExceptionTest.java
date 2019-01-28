package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

class ExceptionTest
{
	public static void main(String []args) throws NumberFormatException, IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=new Integer(br.readLine());
		System.out.println(n);
		ExceptionTest newExp=new ExceptionTest();
		try {
			System.out.println(newExp.calculate(120, 12));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(newExp.calculate(0, 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(newExp.calculate(10, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int calculate(float a, float b) throws Exception
	{
		float c = 0;
		try{
			c= a/b;	
			throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println("Expection"+e);
		}
		finally
		{
		//System.out.println("At the end of expection");	
		}
		
		//System.out.println("Inside Method :"+c);
		return (int) c;	
	}
}