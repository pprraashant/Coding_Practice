package com.java.test;

public class NullAsArugment
{
/*	void Test(Object o)
	{
		System.out.println("Object");
	}
	void Test(String s)
	{
		System.out.println("String");
	}*/
	void Test(Integer i)
	{
		System.out.println("Integer");
	}
	public static void main(String [] args)
	{
		NullAsArugment nl=new NullAsArugment();
		//nl.Test(null);//The method Test(Object) is ambiguous for the type NullAsArugment
		nl.Test(null);
	}
}

