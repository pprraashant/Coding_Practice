package com.java.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XpansionTest2 {
	
	
	public static void main(String [] args) throws InterruptedException
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\exe\\ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		
		
		driver.navigate().to("https://www.amazon.in/");
		Actions action= new Actions(driver);
		WebElement menu=driver.findElement(By.id("nav-link-shopall"));
		WebElement ele=(WebElement) wait.until(ExpectedConditions.visibilityOfAllElements(menu));
		action.moveToElement(menu).build().perform();
		
		/*
		List<WebElement> allelement=driver.findElements(By.xpath("//*"));
		
		for(WebElement element : allelement)
		{
			System.out.println(element.getText());
		}
		*/
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
