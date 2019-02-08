package com.java.test;

public class TestThread extends Thread {
	static int x,y;
	public synchronized void setX(int i)
	{
		x++;
	}
	public synchronized void setY(int j)
	{
		y++;
	}
	public void setXY(int i,int j)
	{
		setX(i);
		setY(j);
	}
	public boolean testXY()
	{
		return x!=y;
	}
	public void run()
	{
		setXY(1,2);
		System.out.println(testXY());
	}
	public static void main(String [] args)
	{
		new TestThread().start();
		new TestThread().start();
	}
}
