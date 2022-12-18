package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeoStoxPassward 
{
	@FindBy (xpath = "//input[@type='password']") private WebElement passwordFiled;
	
	@FindBy(xpath = "//a[text()='Submit']") private WebElement submitButton;
	
	public NeoStoxPassward(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);
	}
	
	public void sendPassword(WebDriver driver,String pass)
	{
	  Utility.wait(driver, 1000);
	  passwordFiled.sendKeys(pass);
	}
	
	public void clickOnSubmitButton(WebDriver driver)
	{
	  Utility.wait(driver, 1000);
	  submitButton.click();
	}
}
