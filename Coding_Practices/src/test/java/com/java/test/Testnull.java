package com.java.test;

public class Testnull 
{

	public void test(Object a)
	{
		System.out.println("Object");
	}
	public void test(String a)
	{
		System.out.println("String");
	}
	public void test(int a)
	{
		System.out.println("int");
	}
	public void test(Integer a)
	{
		System.out.println("Integer");
	}
	public void test(Long a)
	{
		System.out.println("Long");
	}
	
	public static void main(String [] args)
	{
		Testnull n= new Testnull();
		Object a=null;
		//n.test(null);
		n.test(345345345);
		
	}
}
