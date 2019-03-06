package com.java.test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * 
 * *Find all input element
*How to get title of the page
*Write sample and complex xpath code for one element
*How to accept alert
*How to get current window handle
*How to skip test in TestNG
*How to quit driver after each test
*How to get current URL
*How to wait till specific condition
Two SQL questions related to join
 */

public class XpansionTest {
	
	
	public static void main(String [] args) throws InterruptedException
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\exe\\ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		//driver.navigate().to("https://facebook.com");
		System.out.println(driver.findElement(By.id("email")).isDisplayed());
		System.out.println(driver.findElement(By.tagName("title")).getText());
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).click();
		List<WebElement> webelements=driver.findElements(By.xpath("//input"));
		
		for(WebElement ele : webelements)
		{
			System.out.println(ele.getText()+" and Name is: "+ele.getAttribute("name"));
		}
		
		driver.findElement(By.xpath("//*[@id='birthday-help']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.alert('sometext');");
		Thread.sleep(1000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.xpath("//*[@id='privacy-link']")).click();
		
		Set<String> windows =driver.getWindowHandles();
		
		String parentwindow =driver.getWindowHandle();
		Thread.sleep(5000);
		for(String window :windows)
		{
			System.out.println(window);
			if(!window.equals(parentwindow))
			{
			driver.switchTo().window(window);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.alert('sometext');");
			Thread.sleep(1000);
			Alert alert1= driver.switchTo().alert();
			
			alert1.accept();
			driver.close();
			}
		}
		Thread.sleep(5000);
		driver.switchTo().window(parentwindow);
	
		driver.close();
		driver.quit();
	}

}
