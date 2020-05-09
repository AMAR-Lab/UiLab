package testScript;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import GenericLab.BaseFunction;
import GenericLab.Log;

public class testBase {
	public static WebDriver driver;
	public static BaseFunction base = new BaseFunction(driver);
	@BeforeClass
	
	 public void initialize() throws IOException{
	 //open chrome browser
		            base.browser("chrome");
		            Log.info("Browser Oppened");
	 //To open JavaTpoint
	                base.hitURL("https://www.javatpoint.com/");
	Log.info("Application Successfully opened"); 
	}
	 
	 @AfterClass
	 //Test cleanup
	 public void TeardownTest()
	    {
	        base.browserQuite();
	        Log.info("Application Successfully Closed"); 
	    }
	 
	///Application functions-------------------------------
	 
	 public String getElementText() {
		// TODO Auto-generated method stub
		String text = base.getDriver().findElement(By.className("spanh2")).getText();
		return text;
	}
	 public void mouseHover(String xpath) {
		// TODO Auto-generated method stub
        Actions act = new Actions(base.getDriver());
        WebElement element = base.getDriver().findElement(By.xpath(xpath));
        act.moveToElement(element).perform();
	}
	 public void doubleClick(String xpath) {
			// TODO Auto-generated method stub
	        Actions act = new Actions(base.getDriver());
	        WebElement element = base.getDriver().findElement(By.xpath(xpath));
	        act.doubleClick(element).build().perform();
		}
	 public void rightClick(String xpath) {
			// TODO Auto-generated method stub
	        Actions act = new Actions(base.getDriver());
	        WebElement element = base.getDriver().findElement(By.xpath(xpath));
	        act.contextClick(element).build().perform();
		}
	 
	 public void switchWindow() {
		 
		 base.getDriver().findElement(By.xpath("(//a[@class='bannerItemLink'])[1]")).click();
	     String MainWindow=base.getDriver().getWindowHandle();		
	        // To handle all new opened window.				
	        Set<String> s1=base.getDriver().getWindowHandles();		
	        Iterator<String> i1=s1.iterator();		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();				
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                    // Switching to Child window
	                    base.getDriver().switchTo().window(ChildWindow);	                                                                                                           

				// Closing the Child Window.
	                    base.getDriver().close();		
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	        base.getDriver().switchTo().window(MainWindow);				
	}
	 /**
	  * function not working 
	  * @param ScreenshotName
	  * @throws Exception
	  */
	 public static void takeSnapShot(String ScreenshotName) throws Exception{
		 String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		 TakesScreenshot ts = (TakesScreenshot)base.getDriver();
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(source, new File("C:/UsersAdmin/git/repository/Uilab/src/test/java/resource/"+ScreenshotName+timeStamp+".png"));
		 System.out.println("the Screenshot is taken");
		}
	 
}
