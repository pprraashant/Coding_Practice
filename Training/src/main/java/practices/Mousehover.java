package practices;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover{

public static WebDriver driver;

public static void main(String[] args) {

	String workingDir = System.getProperty("user.dir");

	System.setProperty("webdriver.chrome.driver", workingDir + "\\exe\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();


 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 driver.get("http://www.att.com");

 WebElement element = driver.findElement(By.linkText("Shop & support"));

 Actions action = new Actions(driver);

 action.moveToElement(element).build().perform();

 driver.findElement(By.linkText("Bundle")).click();
 

 }

}