package practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateandGet
{
	public static void main(String [] args)
	{
		String workingDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", workingDir + "\\exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url="https://www.att.com";
		driver.get(url);
		System.out.println("let go to facebook");
		//driver.navigate().to("https://www.facebook.com");
		driver.get("https://www.facebook.com");
		System.out.println("Ohh There comes the mananger. back to work");
		driver.get("https://gmail.com");
		driver.navigate().back();
		driver.navigate().back();
	}
}