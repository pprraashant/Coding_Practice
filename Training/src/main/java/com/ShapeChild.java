package com;

class ShapeChild extends Shape
{
	public void printk()
	{
		System.out.println("Inside ShapeChild");
	}
	public void printinfo(Shape S)
	{
		super.printinfo(S);
		System.out.println("Inside ShapeChild");
	}
	
	public static void main(String []args)
	{
		ShapeChild sc= new ShapeChild();
		System.out.println(sc.getClass()); 
		Shape s1=new ShapeChild();
		sc.printk();
		s1.printinfo(s1);
		sc.printinfo(sc);
		
		
	}
}