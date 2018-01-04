package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// 1. Open the web browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Ruby24-x64\\bin\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// 2. Navigate to the web app 
		// http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 3. Enter the email address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com"); ;
		
		// 4. Enter the password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		
		// 5. Click Login
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
			
		// 6. Get confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("Confirmation: "+ message);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if (pageTitle.equals("SDET Training | Account Management")) {
			System.out.println("Page title test PASSED");
		}
		
		// 7. Close the browser
		driver.close();
	}

}
