package com;

public class Shape{
	private int dimesnsion;
	public int getDimesnsion() {
		return dimesnsion;
	}
	public void setDimesnsion(int dimesnsion) {
		this.dimesnsion = dimesnsion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
	public Shape()
	{
		System.out.println("Default constructor");
		
	}
	public void printinfo(Shape S)
	{
		System.out.println("Inside Shape");
	}
	public static void main(String []args)
	{
		
	}
}