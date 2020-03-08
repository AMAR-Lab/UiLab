package testScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import ObjectRepo.LoginPage;
import pages.FBHomePage;

public class testScript1 extends testBase{
	@Test
		public void init() throws Exception{
			 
			 //driver.get("https://www.facebook.com");
			 LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
			 loginpage.setEmail("a 51 Mobiles");
			 loginpage.setPassword("");
			 //loginpage.clickOnLoginButton();
			 
			 /*FBHomePage homepage = PageFactory.initElements(driver, FBHomePage.class);
			 homepage.clickOnProfileDropdown();
			 homepage.verifyLoggedInUserNameText();
			 homepage.clickOnLogoutLink();*/
	}
}
