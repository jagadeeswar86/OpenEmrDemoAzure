package org.slk.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	private static By flowBoardLoc=By.xpath("//div[text()='Flow Board']"); 
	private static By patientClientLoc=By.xpath("//div[text()='Patient/Client']");
	private static By patientLoc=By.xpath("//div[text()='Patients']");
	private static By frame3Loc=By.xpath("(//iframe[@data-bind='location: $data, iframeName: $data.name, '])[3]");
	private static By addPatientLoc=By.id("create_patient_btn1");
	private static By clickNewSearchLoc=By.xpath("//div[text()='New/Search']");
	
	public static void waitFlowBoard(WebDriver driver)
	{
		 WebDriverWait wait=new WebDriverWait(driver, 30);
	      wait.until(ExpectedConditions.presenceOfElementLocated(flowBoardLoc));
	}
	
	public static String textMessage(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public static void mouseOverOnPatientClient(WebDriver driver)
	{
		Actions patientclients = new Actions(driver); // Creating mouseover
		patientclients.moveToElement(driver.findElement(patientClientLoc)).build()
				.perform();
	}
	
	public static void clickPatient(WebDriver driver)
	{
		driver.findElement(patientLoc).click();
	}
	public static void switchToFinFrame(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(frame3Loc));
	}
	public static void closeFrame(WebDriver driver)
	{
		
		driver.switchTo().defaultContent();
		
	}
	public static void addNewPatient(WebDriver driver) throws InterruptedException
	{
		   
			Thread.sleep(2000);
			driver.findElement(addPatientLoc).click();
			}
	
		public static void clickNewSearch(WebDriver driver)
	{
		driver.findElement(clickNewSearchLoc).click();
	}
	
	
		
	
	
	
	
	
}



