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
		DesiredCapabilities dr= new DesiredCapabilities();
		dr.setBrowserName("chrome");
		dr.setPlatform(Platform.WIN10);
		
		WebDriver driver= new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"), dr);
		driver.get("https://www.google.com");
		
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium Software");
		
		System.out.println("Done");
	}
}