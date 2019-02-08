package com.java.test;

enum Test3
{
	SPEED1(130)
	{
		public Test3 next() { return SPEED2;}
	},
	SPEED2(110)
	{
		public Test3 next() { return SPEED3;}
	},
	SPEED3(100)
	{
		public Test3 next() { return SPEED1;}
	};
public abstract Test3 next(); 
private final int km;
Test3(int km)
{
	this.km=km;
}

int getKm()
{
	return km;
}
}
public class Test_Per {
public static void main(String [] args)
{
	for(Test3 test: Test3.values())
	{
		System.out.printf("%s: %d Kms, next is %s", test,test.getKm(),test.next());
	}
}
}
