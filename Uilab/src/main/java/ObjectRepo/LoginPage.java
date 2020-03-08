package ObjectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

    public LoginPage(WebDriver driver){ 
             this.driver=driver; 
    }

//Using FindBy for locating elements
@FindBy(how=How.XPATH, using="//*[@placeholder='Search for products, brands and more']") WebElement homepageSearch;
@FindBy(how=How.XPATH, using="//input[@type='password'][@name='pass']") WebElement passwordTextBox;
@FindBy(how=How.XPATH, using="//input[@type='submit'][@id='u_0_5']") WebElement signinButton;

    // Defining all the user actions (Methods) that can be performed in the Facebook home page

    // This method is to set Email in the email text box
public void setEmail(String strEmail){
	homepageSearch.sendKeys(strEmail);
}
// This method is to set Password in the password text box
public void setPassword(String strPassword){
	homepageSearch.sendKeys(Keys.ENTER);
}
// This method is to click on Login Button
//public void clickOnLoginButton(){
//	signinButton.click();
//}	
}
