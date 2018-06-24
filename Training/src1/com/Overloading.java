package com;

public class Overloading {
	
	int draw(int x,int y)
	{
		return y;
		
	}
	int draw(int x,int y,int z)
	{
		return z;
		
	}
	void draw(char x,int y,int z)
	{
		return;
	}
	public static void main( String [] args)
	{
		Overloading load=new Overloading();
		System.out.println(load.draw(8, 9));
		load.draw(8, 9, 10);
		load.draw('x',9, 7);
	}
}
