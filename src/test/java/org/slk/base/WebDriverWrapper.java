package org.slk.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class WebDriverWrapper {

	protected WebDriver driver;
	
	@Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("ch") String browserName)
    {
    	
    	//String browserName="ch";
    	    	
   	System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
	System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
	System.setProperty("webdriver.ie.driver","driver/IEDriverServer.exe");
		
	
	if(browserName.equals("ch"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equals("ff")) {
			
			driver=new FirefoxDriver();
			
		}
       else {
			
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openemr.io/a/openemr/interface/login/login.php?site=default");
		
     }
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

}
