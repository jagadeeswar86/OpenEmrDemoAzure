package org.slk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	 private static By userNameLoc= By.xpath("//input[@id='authUser']");
	 private static By passwordLoc= By.id("clearPass");
	 private static By languageLoc=By.name("languageChoice");
	 private static By submitLoc=By.xpath("//button[@type='submit']");
	 private static By invalidErrMessageLoc=By.xpath("//div[contains(text(),'Invalid')]");
	 
	public static void sendUserName(WebDriver driver,String username)
	{
		driver.findElement(userNameLoc).sendKeys(username);
	}
	
	
	public static void sendPassword(WebDriver driver,String password)
	{
	   driver.findElement(passwordLoc).sendKeys(password);
	}
		
	public static void selectLanguage(WebDriver driver,String languageText)
	{
		Select selectLang=new Select(driver.findElement(languageLoc));
		selectLang.selectByVisibleText(languageText);
	}
		
	public static void submitButton(WebDriver driver)
	{
		driver.findElement(submitLoc).click();  //login
	}
	
	public static String invalidErrorMessage(WebDriver driver)
	{
		 return driver.findElement(invalidErrMessageLoc).getText();
	}

}
