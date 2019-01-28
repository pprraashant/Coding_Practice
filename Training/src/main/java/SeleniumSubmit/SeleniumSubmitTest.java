package SeleniumSubmit;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumSubmitTest
{
	public static void main(String [] args) throws MalformedURLException
	{
		/*
		
		java -jar selenium-server-standalone-3.141.59.jar -role hub
		to Start the Node
		java -Dwebdriver.chrome.driver=C:\chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://10.75.250.59:4444/grid/register -port=5555 -browser browserName=chrome
		
		 */
		DesiredCapabilities dr= new DesiredCapabilities();
		dr.setBrowserName("chrome");
		dr.setPlatform(Platform.WIN10);
		//dr.setVersion("");
		
		WebDriver driver= new RemoteWebDriver(new URL("http://10.75.250.59:4444/wd/hub"), dr);
		driver.get("https://www.google.com");
		
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium Software");
		
		System.out.println("Done");
	}
}