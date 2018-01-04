package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) throws InterruptedException {
		String name = "SantaClause";
		String email = "test@test.com";
		String password = "pa55word";
		String country = "Brazil";
		String phoneNumber = "1231231234";
		String browser = "";
		WebDriver driver; 
		String gender;
		String weeklyEmail;
		String monthlyEmail;
		String occasionalEmail; 

		
		//1. Open browser 
		driver = utilities.driverFactory.openBrowser(browser);
		
		//2. Visit the page and click on Create Account 
		driver.manage().window().maximize();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");	
		driver.findElement(By.xpath("//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a")).click(); ;
		Thread.sleep(2000);
		
		//3. Fill out the form
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(name);
		driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\'MainContent_txtHomePhone\']")).sendKeys(phoneNumber);
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys(password);
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country); ;
		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		//4. Validate confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("Confrimation: "+conf); 
		
		//5. Close 
		driver.close();
		
		
				
	}

}
