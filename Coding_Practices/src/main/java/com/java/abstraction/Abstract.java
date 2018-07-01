package com.java.abstraction;

public abstract class Abstract {
	
	abstract void method1();
	int method1(int k) 
	{
		System.out.println("Inside"+this.getClass());
		return 0;
	}

}
