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

public class SearchPatientNameTest extends WebDriverWrapper {

	@DataProvider
	public Object[][] searchPatientData() throws IOException {
		Object[][] main = ExcelUtilities.getSheetObjArray("testdata/OpenEmrExcelSheet.xlsx", "searchPatientName");
		return main;
	}

	@Test(priority =5,dataProvider = "searchPatientData")
	public void searchPatientName(String username, String password, String language, String expectedvalue)
			throws InterruptedException {

		LoginPage.sendUserName(driver, username);
		logger.info("enter username");
		LoginPage.sendPassword(driver, password);
		logger.info("enter password");
		LoginPage.selectLanguage(driver, language);
		logger.info("enter language");
		LoginPage.submitButton(driver);
		logger.info("enter submitbutton");

		DashboardPage.mouseOverOnPatientClient(driver);
		logger.info("enter mouseover");
		DashboardPage.clickNewSearch(driver);
		logger.info("click on search ling");

		DashboardPage.switchToFinFrame(driver);
		logger.info("enter finframe");
		
		SearchorAddPatientPage.searchButton(driver);
		logger.info("search buttonenter username");
		DashboardPage.closeFrame(driver);
		logger.info("close frame");

		SearchorAddPatientPage.modalIframe(driver);

		SearchorAddPatientPage.clickName(driver);
		DashboardPage.closeFrame(driver);

		DashboardPage.switchToFinFrame(driver);

		String textmessage = SearchorAddPatientPage.actualTextMessage(driver);

		Assert.assertEquals(textmessage, expectedvalue);
		System.out.println(textmessage);
		DashboardPage.closeFrame(driver);

		
		// https://www.open-emr.org/demo/
	}

}
