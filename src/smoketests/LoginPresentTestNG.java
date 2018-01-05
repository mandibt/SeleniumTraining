package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	WebDriver driver;
	
	
	@Test
	public void loginElementsPresent() {
		boolean emailText = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed() ;
		boolean passText = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		Assert.assertTrue(emailText, "e-mail text present");
		Assert.assertTrue(passText, "password text present");
		
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Starting test");
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver = utilities.driverFactory.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get(webURL);
		 

	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing test");
		driver.close();
	}

}
