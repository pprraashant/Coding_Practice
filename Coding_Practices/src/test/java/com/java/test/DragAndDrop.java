package com.java.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.seleniumhq.jetty9.server.Response.OutputType;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		String workingDir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", workingDir + "\\exe\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String URL = "http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml";

		driver.get(URL);

		// It is always advisable to Maximize the window before performing
		// DragNDrop action

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement From1 = driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div/div[1]/div/div[1]/a"));
		From1.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		WebElement From = driver.findElement(By.xpath(
				".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

		WebElement To = driver.findElement(By.xpath(
				".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(From)

				.moveToElement(To)

				.release(To)

				.build();
		
		
		Thread.sleep(5000);
		dragAndDrop.perform();
		Thread.sleep(6000);
		
	//	WebElement element = driver.findElement(By.name("source"));
	//	WebElement target = driver.findElement(By.name("target"));

		(new Actions(driver)).dragAndDrop(To, From).perform();
		
		System.out.println("Done");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('This is an alert');");
		
		//document.alert("This is a simple alert");
		
		driver.close();
	}

}