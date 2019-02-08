package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CollectionUse
{
	public static void main(String [] args)
	{
		List<Integer> no=new ArrayList<Integer>();
		no.add(1);
		no.add(2);
		no.add(2);
		System.out.println(no);
		no.remove(2);
		System.out.println(no);
		no.remove(new Integer(2));
		System.out.println(no);
		
		List<Number> genric=new ArrayList<Number>();
		genric.add(12.000);
		genric.add(12);
		genric.add(12.4);
		//System.out.println(genric);
		
		//Collections.sort(genric);
		//System.out.println(genric);
		
		List genric1=new ArrayList();
		genric1.add(12.0);
		genric1.add(12);
		genric1.add(12.4);
		System.out.println(genric1);
		
		Collections.sort(genric1);
		System.out.println(genric1);
	}
}