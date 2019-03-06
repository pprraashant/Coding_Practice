package com.java.test;
/* IMPORTANT: Multiple classes and nested static classes are supported */


//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
     
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());                // Reading input from STDIN
        String numberstr=br.readLine();
        String [] numbers=numberstr.split(" ");
        int [] inputs= new int [num];
        for(int i=0;i<num;i++)
        {
        	inputs[i] = Integer.parseInt(numbers[i]);  
        	printFizzBuzz(Integer.parseInt(numbers[i]));
        }
        
        for(int i=0;i<num;i++)
        {
        	;
        }

    }
    public static void printFizzBuzz(int num)
    {
    	 for(int i=1;i<=num;i++)
         {
         	if((i % 3 ==0)&&(i % 5 ==0))
         		System.out.println("FizzBuzz");
         	else
         	if(i % 3 ==0)
         		System.out.println("Fizz");
         	else
         	if(i % 5 ==0)
         		System.out.println("Buzz");
         	else
         		System.out.println(i);
         	
         }
    }
}
