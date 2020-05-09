package testScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testScript1 extends testBase{

	
	@Test(enabled=true,priority = 1)
		public void openJava() throws Exception{
		Thread.sleep(2000);
		base.selectElementfromList("Java");
		Thread.sleep(5000);
		String str = getElementText();
		Assert.assertEquals(str, "Java Tutorial");
		Thread.sleep(5000);
		System.out.println("Executed SuccessFully");
		takeSnapShot("openJava");
	}
	@Test(enabled=false,priority = 2)
	private void openServlets() throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		base.selectElementfromList("Servlet");
		 Robot robot = new Robot();
	       // Simulate a mouse click
	                    robot.mousePress(InputEvent.BUTTON1_MASK);
	                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
	      // ctrl + T & ctrl TAB  
	                robot.keyPress(KeyEvent.VK_CONTROL);
	                robot.keyPress(KeyEvent.VK_T);
	                // CTRL+T is now pressed 
	                robot.keyRelease(KeyEvent.VK_T);
	                robot.keyRelease(KeyEvent.VK_CONTROL);
	                Thread.sleep(2000);            
	    base.hitURL("https://www.bing.com/");     
	    Thread.sleep(2000);
	    Assert.assertEquals(base.getDriver().getTitle(), "Bing");         
	    Thread.sleep(2000);
	    System.out.println("Executed SuccessFully");
	}
	@Test(enabled=true,priority = 3)
	private void openNaukri() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
          base.hitURL("https://www.naukri.com/");
          
	                Thread.sleep(2000);
	                switchWindow();
	                System.out.println(base.getDriver().getTitle());
	    Assert.assertEquals(base.getDriver().getTitle(), "Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com");         
	    Thread.sleep(7000);
	    System.out.println("Executed SuccessFully");
	    takeSnapShot("openNaukri");
	}
}
