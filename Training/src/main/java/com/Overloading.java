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
		//System.out.println(load.draw(8, 9));
		load.draw(8, 9, 10);
		load.draw('x',9, 7);
		
		OverriddingExample ridding= new OverriddingExample();
		OverriddingExample riddingchild=new OverriddingChild();
		OverriddingChild riddingchildhimself=new OverriddingChild();
		System.out.println(ridding.draw());
		System.out.println(riddingchild.draw());
		System.out.println(riddingchildhimself.draw());
		System.err.println(""+ridding.x+" "+riddingchild.x+" "+riddingchildhimself.x);
	}
}