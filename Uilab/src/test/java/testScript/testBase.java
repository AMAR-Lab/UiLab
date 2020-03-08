package testScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import GenericLab.BaseFunction;

public class testBase {
	public static WebDriver driver = null;
	public static BaseFunction base = new BaseFunction(driver);
	
	@BeforeSuite
	
	 public void initialize() throws IOException{
	 //open chrome browser
		            base.browser("chrome");
	 //To open FlipKart
	                base.hitURL("https://www.flipkart.com/");
	 
	 }
	 
	 @AfterSuite
	 //Test cleanup
	 public void TeardownTest()
	    {
	        base.browserQuite();
	    }
}
