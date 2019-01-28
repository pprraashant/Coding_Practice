package com;
class ThreadDemo
{
	public void print()
	{
		for(int i=0;i<5;i++)
			System.out.println("Inside Print"+i);
	}
	public static void main(String []args)
	{
		ThreadDemo td= new ThreadDemo();
		MyThread mt=new MyThread();
		
		mt.start();
		//mt.run();
		td.print();
		GuessANumber ga=new GuessANumber(5);
		ga.start();
	}
}