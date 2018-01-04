package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		//1. Create a WebDriver session
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//2. Visit the page and click on Create Account 
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");	
		driver.findElement(By.xpath("//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a")).click(); ;
		Thread.sleep(2000);
		
		//3. Fill out the form
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("SantaClause");
		driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("test@test.com");
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("SantaClause");
		driver.findElement(By.xpath("//*[@id=\'MainContent_txtHomePhone\']")).sendKeys("132123321");
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("pa55word");
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("pa55word");
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Brazil"); ;
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
