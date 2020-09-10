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

	@Test(dataProvider = "searchPatientData")
	public void searchPatientName(String username, String password, String language, String expectedvalue)
			throws InterruptedException {

		LoginPage.sendUserName(driver, username);
		LoginPage.sendPassword(driver, password);
		LoginPage.selectLanguage(driver, language);
		LoginPage.submitButton(driver);

		DashboardPage.mouseOverOnPatientClient(driver);
		DashboardPage.clickNewSearch(driver);

		DashboardPage.switchToFinFrame(driver);
		// SearchorAddPatientPage.iFrame3(driver);
		SearchorAddPatientPage.searchButton(driver);
		DashboardPage.closeFrame(driver);

		SearchorAddPatientPage.modalIframe(driver);

		SearchorAddPatientPage.clickName(driver);
		DashboardPage.closeFrame(driver);

		DashboardPage.switchToFinFrame(driver);

		String textmessage = SearchorAddPatientPage.actualTextMessage(driver);

		Assert.assertEquals(textmessage, expectedvalue);
		System.out.println(textmessage);
		DashboardPage.closeFrame(driver);

		driver.quit();
		// https://www.open-emr.org/demo/
	}

}
