package org.slk.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PDemo {

	
	@DataProvider
	public Object[][] invalidInputData()
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
			
	
	
	
	@Test(dataProvider ="invalidInputData")
	public static void invalidInput(String Username, String Password)
	{
		System.out.println(Username+Password);
	}
}
