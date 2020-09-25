package org.slk.test;

import org.slk.base.WebDriverWrapper;
import org.slk.pages.AddAdminUserPage;
import org.testng.annotations.Test;

public class AddAdminUser extends WebDriverWrapper  {

	@Test
	public void addNewAdminUser() throws InterruptedException
	
	{
         
         
      
		AddAdminUserPage ap=new AddAdminUserPage(driver);
		
		ap.sendUserName();  
		ap.sendPassword();
		ap.selectLanguage();
		ap.submitButton();    // login
		Thread.sleep(2000);
		
		ap.mouseOverAdmin();
		Thread.sleep(2000);
	
		ap.clickUsers();
	  		Thread.sleep(2000);//frame2
		ap.frame2();
		ap.addUser();
		ap.closeframe();
		Thread.sleep(2000);
		ap.adframe();
		Thread.sleep(2000);
		ap.username();
		Thread.sleep(2000);
		ap.passwd();
		Thread.sleep(2000);
		ap.fname();
		Thread.sleep(2000);
		ap.lname();
		Thread.sleep(2000);
		ap.acessgp();
		Thread.sleep(2000);
		ap.closebtn();
		Thread.sleep(2000);
		ap.closeframe();
		
		// users frame
		//driver.switchTo().frame(driver.findElement(By.name("//iframe[@name='logoutinnerframe']")));
		
		//driver.findElement(By.linkText("//*[text()='Users']")).click();
		//driver.switchTo().defaultContent();
		
		//add users frame
         // driver.switchTo().frame(driver.findElement(By.name("(//iframe[@data-bind='location: $data, iframeName: $data.name, '])[2]")));
		
          //driver.findElement(By.xpath("//*[text()='Add User']")).click();
		//driver.switchTo().defaultContent();
		
		//popup frame
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		//driver.findElement(By.xpath("(//*[@type='entry'])[1]")).sendKeys("TestApple");  //username
		//driver.findElement(By.xpath("((//*[@type='password'])[1]")).sendKeys("Happy123"); 
		//driver.findElement(By.xpath("(//*[@type='entry'])[2]")).sendKeys("Apple1");  //fname
		//driver.findElement(By.xpath("(//*[@type='entry'])[4]")).sendKeys("Test");   //lastName
		
		//Select dp=new Select(driver.findElement(By.name("//*[@name='access_group[]']")));
		//dp.selectByVisibleText("Emergency Login");
		//driver.findElement(By.name("//*[@class='btn btn-link btn-cancel']")).click(); //password
		
		//driver.switchTo().defaultContent();
		
				
	}
}
