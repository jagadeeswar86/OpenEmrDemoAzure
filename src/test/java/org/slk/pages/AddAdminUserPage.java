package org.slk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddAdminUserPage {

	public By adminsLoc=By.xpath("//*[text()='Administration']");
	
	public By usersLoc=By.xpath("//*[text()='Users']");
	public By frame2Loc=By.xpath("(//iframe[@data-bind='location: $data, iframeName: $data.name, '])[3]");
	 public By addUserLoc=By.linkText("Add User"); //*[text()='Add User']
	 public By adframeLoc=By.xpath("//iframe[@id='modalframe']");
	 public By userLoc=By.xpath("(//*[@type='entry'])[1]");
	 public By pwdLoc=By.xpath("(//*[@type='password'])[1]");
	 public By fnLoc=By.xpath("(//*[@type='entry'])[2]");
	 public By lnLoc=By.xpath("(//*[@type='entry'])[4]");
	 public By closeLoc=By.xpath("//*[@class='btn btn-link btn-cancel']");
	 public By accessLoc=By.xpath("//*[@name='access_group[]']");
	 private  By userNameLoc= By.xpath("//input[@id='authUser']");
	 private  By passwordLoc= By.id("clearPass");
	 private  By languageLoc=By.name("languageChoice");
	 private  By submitLoc=By.xpath("//button[@type='submit']");
	 private By innerframeLoc=By.xpath("//iframe[@name='logoutinnerframe']");
	
	private WebDriver driver;
	
	public AddAdminUserPage(WebDriver driver)
	{
		this.driver=driver;
	}
		
		public  void sendUserName()
	{
		driver.findElement(userNameLoc).sendKeys("admin");
	}
		
	public  void sendPassword()
	{
	   driver.findElement(passwordLoc).sendKeys("pass");
	}
		
	public  void selectLanguage()
	{
		Select selectLang=new Select(driver.findElement(languageLoc));
		selectLang.selectByVisibleText("Default - English (Standard)");
	}
		
	public  void submitButton()
	{
		driver.findElement(submitLoc).click();  //login
	}
	public  void mouseOverAdmin() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(adminsLoc)).build().perform();
		Thread.sleep(2000);
		
	}
	
	public void innerframe()
	{
		driver.switchTo().frame(driver.findElement(innerframeLoc));
	}
	
	public  void clickUsers()
	{
		driver.findElement(usersLoc).click();
	}
	public  void frame2()
	{
		 driver.switchTo().frame(driver.findElement(frame2Loc));
		 
}
	public  void addUser()
	{
     driver.findElement(addUserLoc).click();
	}
	
	public void closeframe()
	{
		driver.switchTo().defaultContent();
	}
	public void adframe() {
	driver.switchTo().frame(driver.findElement(adframeLoc));
	}
	public void username() {
	driver.findElement(userLoc).sendKeys("TestApple");  //username
	}
	public void passwd() {
	driver.findElement(pwdLoc).sendKeys("Happy123"); 
	}
	public void fname() {
	driver.findElement(fnLoc).sendKeys("Apple1");  //fname
	}
	public void lname() {
	driver.findElement(lnLoc).sendKeys("Test");   //lastName
	}
	public void acessgp() {
	Select dp=new Select(driver.findElement(accessLoc));
	dp.selectByVisibleText("Emergency Login");
	}
	public void closebtn() {
	driver.findElement(closeLoc).click(); //password
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

