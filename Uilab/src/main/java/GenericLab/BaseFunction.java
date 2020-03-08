package GenericLab;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseFunction {

	WebDriver driver;

    public BaseFunction(WebDriver driver){ 
             this.driver=driver; 
    }
	/**
	 * method describe for select browsertype 
	 * @param browser
	 */
	public void browser(String browser) {
		try {
			if (browser == "chrome") {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Lib\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} else if (browser == "firefox") {

			} else if (browser == "ie") {

			} else {
				System.out.println("browser driver issue");
			}
		} catch (Exception e) {
			System.err.println("browser driver issue");
			e.printStackTrace();
		}
	}
	/**
	 * method describe for hit the url.
	 * @param url
	 */
	public void hitURL(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.err.println("url issue");
			e.printStackTrace();
		}
	}
	/**
	 * method is describe for quit browser.
	 */
	public void browserQuite() {
			driver.quit();
	}
	/**
	 * method is describe for close browser.
	 */
	public void browserClose() {
			driver.close();
	}
	/**
	 * method is describe for clear the textbox and enter the value in text box.
	 */
	public void typeText(WebElement element,String text) {
		element.clear();	
		element.sendKeys(text);
	}
	/**
	 * method is describe for enter the value in text box.
	 */
	public void click(WebElement element,String text) {
			element.click();
	}
}
