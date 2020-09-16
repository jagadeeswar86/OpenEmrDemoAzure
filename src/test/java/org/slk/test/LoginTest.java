package org.slk.test;

import java.io.IOException;

import org.slk.base.WebDriverWrapper;
import org.slk.pages.DashboardPage;
import org.slk.pages.LoginPage;
import org.slk.utilities.ExcelUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	
public class LoginTest extends WebDriverWrapper{
	
		
	@DataProvider
	public Object[][] validInputData()
	{
	Object[][] main= new Object[5][2];
	        main[0][0]="admin";
			main[0][1]="pass";	
			main[1][0]="physician";
			main[1][1]="physician";
			main[2][0]="clinician";
			main[2][1]="clinician";
			main[3][0]="accountant";
			main[3][1]="accountant";
			main[4][0]="receptionist";
			main[4][1]="receptionist";
			return main;
					
			}
			
		
	
	@Test(priority =1,dataProvider ="validInputData")
	
	public  void validCredintailsTest1(String Username, String Password) {
		
		LoginPage.sendUserName(driver, Username);
		LoginPage.sendPassword(driver, Password);
		LoginPage.selectLanguage(driver, "Default - English (Standard)");
		LoginPage.submitButton(driver);
			     
		String textmessage=DashboardPage.textMessage(driver);
	    
	     Assert.assertEquals(textmessage, "OpenEMR");
	     driver.quit();
	}
	
	@DataProvider
	public Object[][] validCredintailsData() throws IOException
	{
		Object[][] main=ExcelUtilities.getSheetObjArray("testdata/OpenEmrExcelSheet.xlsx", "validCredintailsTest");
		return main;
		
	}
	
	
	
	@Test(priority =3,dataProvider ="validCredintailsData")
	public  void validCredintailsTest(String username,String password,String language,String expectedvalue) {
		
		LoginPage.sendUserName(driver, username);
		LoginPage.sendPassword(driver, password);
		LoginPage.selectLanguage(driver, language);  
		LoginPage.submitButton(driver);
		
		DashboardPage.waitFlowBoard(driver);
      
		String textmessage=DashboardPage.textMessage(driver);
	    
	     Assert.assertEquals(textmessage, expectedvalue);
	     driver.quit();
	}
	
	
	
	@DataProvider
	public Object[][] invalidCredintailsData() throws IOException
	{
		Object[][] main=ExcelUtilities.getSheetObjArray("testdata/OpenEmrExcelSheet.xlsx", "invalidCredintailsTest");
		return main;
	}
	
	
	@Test(priority = 2,dataProvider ="invalidCredintailsData")
	public void invalidCredintailsTest(String username,String password,String language,String expectedvalue) {
		
		LoginPage.sendUserName(driver, username);
		LoginPage.sendPassword(driver, password);
		LoginPage.selectLanguage(driver, language); 
		LoginPage.submitButton(driver);

		String errormessage =LoginPage.invalidErrorMessage(driver); 
	
		Assert.assertEquals(errormessage, expectedvalue);

		// expected value is true
		// Assert.assertTrue(errormessage.contains("Invalid username or password"));
		driver.quit();
	}

}
