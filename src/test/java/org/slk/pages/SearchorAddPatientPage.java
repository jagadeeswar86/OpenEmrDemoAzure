package org.slk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchorAddPatientPage {

	private static By frame4Loc=By.xpath("(//iframe[@data-bind='location: $data, iframeName: $data.name, '])[4]");
	private static By selectTitleloc=By.xpath("//select[@title='Title']");
	private static By firstNameLoc=By.xpath("//input[@title='First Name']");
	private static By lastNameLoc=By.xpath("//input[@title='Last Name']");
	private static By doBLoc=By.xpath("//input[@title='Date of Birth']");
	private static By sexLoc=By.xpath("(//select[@title='Sex'])[1]");
	private static By newPatientButtonLoc=By.xpath("//button[@value='Create New Patient']");
	private static By modelFrameLoc=By.xpath("//iframe[@class='embed-responsive-item modalIframe']");
	private static By confirmpatientButtonLoc=By.xpath("//input[@value='Confirm Create New Patient']");
	private static By actualmessageLoc=By.xpath("//*[contains(text(),'Medical Record')]");
	//private static By actualmessageLoc=By.xpath("//*[text()='Medical Record Dashboard - Phil Belford   ']");
	private static By clickNameLoc=By.xpath("//td[text()='Belford, Phil']");
	private static By searchLoc=By.xpath("//button[@class='btn btn-default btn-search']");
	public static void addPatientFrame(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(frame4Loc));
	}
	
	public static void selectTitle(WebDriver driver,String text)
	
	{
		Select name = new Select(driver.findElement(selectTitleloc)); 
        name.selectByVisibleText(text);
	}
	
	public static void firstName(WebDriver driver,String firstname)
	{
		driver.findElement(firstNameLoc).sendKeys(firstname);
	}
	
	public static void lastName(WebDriver driver,String lastname)
	{
		driver.findElement(lastNameLoc).sendKeys(lastname);
	}
	
	public static void dob(WebDriver driver,String date)
	{
		driver.findElement(doBLoc).sendKeys(date);
	}
	public static void sex(WebDriver driver,String text)
	{
		Select sex = new Select(driver.findElement(sexLoc));
		sex.selectByVisibleText(text);
	}
	
	public static void newPatientButton(WebDriver driver)
	{
	driver.findElement(newPatientButtonLoc).click();
	
	}
	
	public static void modalIframe(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.switchTo()
		.frame(driver.findElement(modelFrameLoc));	
	
	}
	public static void confirmPatientButton(WebDriver driver)
	{
		driver.findElement(confirmpatientButtonLoc).click();
	
	}
	
	public static void waitAlerts(WebDriver driver)
	{
		
	    
	     WebDriverWait wait=new WebDriverWait(driver,40);
		 wait.until(ExpectedConditions.alertIsPresent());
	}
	public static String alertsTextMessage(WebDriver driver)
	{
	 String alerttext= driver.switchTo().alert().getText(); // ------------alerts
	return alerttext;
	}
	
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public static String actualTextMessage(WebDriver driver)
	{
	return	driver.findElement(actualmessageLoc).getText();
	}
	
	
	
	
	public static void searchButton(WebDriver driver)
	{
		  driver.findElement(searchLoc).click();
	}
	
	public static void clickName(WebDriver driver)
	{
	 driver.findElement(clickNameLoc).click();
	}
	 
	 
	 
	 
	 
	 
}
