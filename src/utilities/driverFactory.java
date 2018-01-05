package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class driverFactory {
	
	//This method will return webdriver object
	
	public static WebDriver openBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
		}
		else  if (browser.equalsIgnoreCase("ie")) {
			return new InternetExplorerDriver();
		}
		else {			
			return new ChromeDriver();
		}
	}
}
