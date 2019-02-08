package com.java.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) 
    {
    	
    	sortarray(q);


    }
    static int [] sortarray(int [] needtosort)
    {
    	int arraylength=needtosort.length;
    	int sortedarray[]=new int[arraylength];
    	int temp=Integer.MIN_VALUE;
    	for(int i=0;i<arraylength;i++)
    	{
    		sortedarray[i]=needtosort[i];
    	}
    	
    	for(int i=0;i<arraylength;i++)
    	{
    		for(int j=i+1;j<arraylength;j++)
    		{
    			
    			if(sortedarray[i]>sortedarray[j])
    			{
    				temp=sortedarray[i];
    				sortedarray[i]=sortedarray[j];
    				sortedarray[j]=temp;
    			}
    		}
    	}
    	return sortedarray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
