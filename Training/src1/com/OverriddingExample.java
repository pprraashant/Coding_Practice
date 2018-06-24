package com;

public class OverriddingExample {
	
	int x=0 , y=0;

	int draw()
	{
		return 0;
	}
	int draw(int x)
	{
		return 0;
	}
}
class OverriddingChild extends OverriddingExample
{

		int x=1,y=1;
		
		int draw()
		{
			return 1;
		}
		public static void main( String [] args)
		{
			
			System.err.println("Killers know everything");
		}
}
