package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	
	// CLASS level declared variables and objects can be used in multiple methods through the program
	
	WebDriver driver;
	String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

	@Test
	public void pageTitleTest() {
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Before
	public void setUp() {
		System.out.println("Initializing webdriver");
		driver = utilities.driverFactory.openBrowser("chrome");	
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		System.out.println("Closing the browser");
		driver.close();
	}
}
