package org.slk.test;

import java.io.IOException;


import org.slk.base.WebDriverWrapper;
import org.slk.pages.DashboardPage;
import org.slk.pages.LoginPage;
import org.slk.pages.SearchorAddPatientPage;
import org.slk.utilities.ExcelUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddPatientNameTest extends WebDriverWrapper {
	
		
	@DataProvider
	public Object[][] patientRegData() throws IOException
	{
		Object[][] main=ExcelUtilities.getSheetObjArray("testdata/OpenEmrExcelSheet.xlsx", "patientRegName");
		return main;
	}
	@Test(priority =4,dataProvider ="patientRegData")
	
	public void patientRegName(String username,String password,String language
			,String title,String fName,String lName,String dobirth,String gender,String expectedvalue) throws InterruptedException {
		
		LoginPage.sendUserName(driver, username);  
		LoginPage.sendPassword(driver, password);
		LoginPage.selectLanguage(driver, language);
		LoginPage.submitButton(driver);    // login

		DashboardPage.mouseOverOnPatientClient(driver);

		DashboardPage.clickPatient(driver);

		//Thread.sleep(2000); // -------------------------first frame created------------
		DashboardPage.switchToFinFrame(driver);
		DashboardPage.addNewPatient(driver);
		DashboardPage.closeFrame(driver);
		

		 // -------------------------Second frame created------------
		SearchorAddPatientPage.addPatientFrame(driver);
		SearchorAddPatientPage.selectTitle(driver,title);
		SearchorAddPatientPage.firstName(driver,fName);
		SearchorAddPatientPage.lastName(driver,lName);
		SearchorAddPatientPage.dob(driver,dobirth);
	    SearchorAddPatientPage.sex(driver, gender);
	   	SearchorAddPatientPage.newPatientButton(driver);
		DashboardPage.closeFrame(driver);
		 // --------------------frame closed

		// -------------------------Three frame created------------
				
        SearchorAddPatientPage.modalIframe(driver);
		SearchorAddPatientPage.confirmPatientButton(driver);
		DashboardPage.closeFrame(driver); // --------------------frame closed

		
		if( !(username.equals("accountant") || username.equals("receptionist")))
		{
			SearchorAddPatientPage.waitAlerts(driver);
		SearchorAddPatientPage.alertsTextMessage(driver); // ------------alerts
		SearchorAddPatientPage.alertAccept(driver);
	    }
	    	
				

		// -------------------------four frame created------------'
	   SearchorAddPatientPage.addPatientFrame(driver);
		//driver.switchTo().frame(driver
				//.findElement(By.xpath("(//iframe[@data-bind='location: $data, iframeName: $data.name, '])[4]")));

	   String textmessage = SearchorAddPatientPage.actualTextMessage(driver);
	   
//		String textmessage = driver
//				.findElement(By.xpath("//*[containt(text(),'Medical Record Dashboard - HelloHai Test   ']")).getText();

		
		 Assert.assertEquals(textmessage, expectedvalue);
		DashboardPage.closeFrame(driver);; // --------------------frame closed
		//driver.quit();
	}
}

