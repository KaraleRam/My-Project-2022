package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.Utility;

public class Base 
{
	protected WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
	  System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get(Utility.readDataFromPropertyFile("url"));
	  driver.manage().window().maximize();
	  Utility.wait(driver, 1000);
	}
	
	public static void closingBrowser(WebDriver driver) throws InterruptedException
	{
	  Thread.sleep(500);
	  driver.close();
	}

}
