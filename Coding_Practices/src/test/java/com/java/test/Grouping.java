package com.java.test;

import org.testng.annotations.Test;

import com.java.abstraction.ExtendAbstract;

public class Grouping {
  
  @Test (groups="main")
  public void main1() {
	  System.out.println("in main1");
	  ExtendAbstract abe=new ExtendAbstract();
		abe.method1();
  }
  @Test (groups="main")
  public void main() {
	  System.out.println("in main");
	  ExtendAbstract abe=new ExtendAbstract();
		abe.method1();
  }
  @Test (groups="ain")
  public void ain1() {
	  System.out.println("in ain1");
	  ExtendAbstract abe=new ExtendAbstract();
		abe.method1();
  }
  @Test (groups="ain")
  public void ain() {
	  System.out.println("in ain");
	  ExtendAbstract abe=new ExtendAbstract();
		abe.method1();
  }
}
