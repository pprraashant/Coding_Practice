package com.java.outputtrace;
//IOException and RuntimeException
import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionParentChild {
	
	public void methodcheck() throws RuntimeException
	{
		int n= 0;
		try
		{
		int result = 40/n;
		
		System.out.println(result);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("array index out of bound");
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Arithmetic Exception");
		}
		
		try
		{
			File j= new File("");
			System.out.println(j.canRead());
		
		int result = 40/n;
		
		System.out.println(result);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Arithmetic Exception");
		}
		
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("array index out of bound");
		}
	}
	
	public static void main(String [] args) 
	{
		int n= args.length;
		try
		{
		int result = 40/n;
		
		System.out.println(result);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("array index out of bound");
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Arithmetic Exception");
		}
		
		try
		{
		int result = 40/n;
		
		System.out.println(result);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Arithmetic Exception");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("array index out of bound");
		}
		
		ExceptionParentChild ex= new ExceptionParentChild();
		ex.methodcheck();
		
	}

}
