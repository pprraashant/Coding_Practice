package com.java.test;

public class UnderScoreAsVariableName {

	public static void main(String [] args)
	{
		int _ =10;
//- '_' should not be used as an identifier, since it is a reserved keyword from source  level 1.8 on
		System.out.println(_);
	}
}
