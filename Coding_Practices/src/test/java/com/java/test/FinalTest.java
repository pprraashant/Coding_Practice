package com.java.test;

public class FinalTest {
	
	final int finalme;
	{
	//	finalme=5;
	}
	final StringBuilder str= new StringBuilder("Prashant Pawar");
	final String me="Prashant";
	{
	finalme=7;
	}
	
	public static void main()
	{}
	public static void main(String []args)
	{
		FinalTest ft= new FinalTest();
		System.out.println(ft.finalme);
		//ft.me=ft.me+"kiiler";
		System.out.println(ft.str.append("is working in Amdocs"));
		
		int arr[] = {1, 2, 3}; 
        
        // final with for-each statement 
        // legal statement 
        for (final int i : arr) 
            System.out.print(i + " "); 
	}
	

}
