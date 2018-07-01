package com.java.abstraction;

public class ExtendAbstract extends Abstract
{

	@Override
	public
	void method1() {
		System.out.println("Inside"+this.getClass());
		
	}
	public static void main(String [] args)
	{
		ExtendAbstract abe=new ExtendAbstract();
		abe.method1();
		abe.method1(9);
		
		Abstract abe1=new ExtendAbstract();
		abe1.method1();
		abe1.method1(9);
	}
	

}
