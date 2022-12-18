package testNGClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pomClasses.NeoStoxHome;
import pomClasses.NeoStoxPassward;
import pomClasses.NeoStoxSignIn;
import pomClasses.Utility;

public class ValidateACBalanceTest extends Base
{
	  NeoStoxSignIn login;
	  NeoStoxPassward password;
	  NeoStoxHome home;
	
@BeforeClass
	public void launchNeoStox() throws IOException
	{
	  launchBrowser();
	  login= new NeoStoxSignIn(driver);
	  password= new NeoStoxPassward(driver);
	  home= new NeoStoxHome(driver);
	}
	
@BeforeMethod
	public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
	  login.sendMobileNum(driver, Utility.readDataFromPropertyFile("mobileNum") );
	  login.clickOnSignInButton(driver);
	  Thread.sleep(1000);
	  password.sendPassword(driver, Utility.readDataFromPropertyFile("passward"));
	  password.clickOnSubmitButton(driver);
	  Thread.sleep(1000);
	  home.popUpHandle(driver);
	}
	
@Test
	public void validateAcBalance()
	{
	  Assert.assertNotNull(home.getBalance(driver));
	}

	
@AfterMethod
	public void logout()
	{
	  home.logoutFormNeoStox(driver);
	}

@AfterClass
	public void closeApplication() throws InterruptedException
	{
	  closingBrowser(driver);
	}



}
