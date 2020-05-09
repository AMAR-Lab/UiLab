package GenericLab;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseFunction {

	WebDriver driver;

    public BaseFunction(WebDriver driver){ 
             this.driver=driver; 
    }
    
	public WebDriver getDriver() {
		return driver;
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
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				options.addArguments("start-maximized"); 
			    options.addArguments("enable-automation"); 
			    options.addArguments("--no-sandbox"); 
			    options.addArguments("--disable-infobars"); 
			    options.addArguments("--disable-dev-shm-usage"); 
			    options.addArguments("--disable-browser-side-navigation"); 
			    options.addArguments("--disable-gpu");
			    
			    
				driver = new ChromeDriver(options);
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
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    System.out.println(driver.getTitle());
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
	public void scrollToElement(WebElement element) {
		// TODO Auto-generated method stub
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	public void selectElementfromList(String menuOption) {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> allelement = driver.findElements(By.xpath("//*[@class='ddsmoothmenu']//a"));
			Thread.sleep(2000);
			for (WebElement webElement : allelement) {
				if (webElement.getText().equalsIgnoreCase(menuOption)) {
					webElement.click();
					//scrollToElement(webElement);
				///driver.findElement(By.xpath("//a[text()='See more']")).click();
				switchIFrame("//a[text()='See more']");
				}
			}
		} catch (StaleElementReferenceException e) {
			//System.err.println("StaleElementReferenceException issue");
			//e.printStackTrace();
		}catch (Exception e) {
			//System.err.println(" issue in function");
		}
	}
	/**
	 * Function describe for handle frame.
	 * @param elementXpath
	 */
	public void switchIFrame(String elementXpath) {
		// TODO Auto-generated method stub
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> allelement = driver.findElements(By.tagName("iframe"));
			for (WebElement webElement : allelement) {
				driver.switchTo().frame(webElement);
				if (driver.findElements(By.xpath(elementXpath)).size()>0) {
					System.out.println("switched to frame");
					break;
				}
				driver.switchTo().defaultContent();
			}
		} catch (Exception e) {
			System.out.println("no iframe");
			driver.switchTo().defaultContent();
		}
	}
	
}
