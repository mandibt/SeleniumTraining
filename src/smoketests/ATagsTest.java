package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;
	
		@Test
		public void loginElementsPresent() {
			System.out.println("Running test");
			
			// We want to test the presence of A tags - hyperlink
			List <WebElement> aElements = driver.findElements(By.tagName("a"));
			for (WebElement aElement : aElements) {
				System.out.println("Elem: "+aElement.getText());
				if (aElement.getText().equals("CREATE ACCOUNT")) {
					aElement.click();
					break;
				}
			}
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
