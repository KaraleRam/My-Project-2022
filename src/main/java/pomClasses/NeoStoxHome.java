package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeoStoxHome 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	@FindBy(id = "lbl_username") private WebElement userName;
	@FindBy(id="lbl_curbalancetop") private WebElement balance;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logoutButton;
	
	public NeoStoxHome(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);
	}
	
	public void popUpHandle(WebDriver driver)
	{
	  Utility.wait(driver, 1000);
	  okButton.click();
	  Utility.scrollIntoView(driver, closeButton);
	  Utility.wait(driver, 1000);
	  closeButton.click();
	}
	
	public String getUserName()
	{
	  String actualUserName = userName.getText();
	  return actualUserName;
	}
	
	public String getBalance(WebDriver driver)
	{
	  Utility.wait(driver, 1000);
	  String actualBalance = balance.getText();
	  return actualBalance;
	}
	
	public void logoutFormNeoStox(WebDriver driver)
	{
	  Utility.wait(driver, 1000);
	  userName.click();
	  Utility.wait(driver, 1000);
	  logoutButton.click();
	}


}
