package com.java.test;

import org.testng.annotations.Test;

import com.java.abstraction.ExtendAbstract;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestTest {
	@Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String browser) {
	  System.out.println("@BeforeMethod "+browser);
	  if(browser.contains("IE"))
		  throw new SkipException("Skipping the test case");
		  
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
  }


  @Test
  public void main() {
	  
	  ExtendAbstract abe=new ExtendAbstract();
		abe.method1();
  }
}
