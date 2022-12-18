package pomClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
	  //create object of Properties class
	  Properties prop= new Properties();
	  //create object of FileInputStream
	  FileInputStream myFile= new 
	  FileInputStream("C:\\Users\\ramka\\eclipse-workspace\\23rd jul moorning B\\src\\myPackage\\MavenProperty\\PropertyFile.properties");
	  prop.load(myFile);
	  String value = prop.getProperty(key);
	  return value;
	}
	
	public static void takeSceenshot(WebDriver driver, String fileName) throws IOException
	{
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest= new File("C:\\Java\\Screenshot\\"+fileName+".png");
	  FileHandler.copy(src, dest);
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(true)",element );
	}
	
	public static void wait(WebDriver driver, int waittime)
	{
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
	}
}
