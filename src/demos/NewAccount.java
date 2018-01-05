package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) throws InterruptedException {
		String name = "SantaClause";
		String email = "test@test.com";
		String password = "pa55word";
		String country = "Brazil";
		String phoneNumber = "1231231234";
		String browser = "";
		String gender = "fEMALE";
		boolean weeklyEmail = true;
		boolean monthlyEmail = true;
		boolean occasionalEmail = false; 
		
		//1. Define WebDriver
		WebDriver driver = utilities.driverFactory.openBrowser(browser);

		
		//2. Visit the page and click on Create Account 
		driver.manage().window().maximize();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");	
		
		WebElement createAccount	= driver.findElement(By.xpath("//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a"));
		createAccount.click(); ;
		Thread.sleep(2000);
		
		//3. Fill out the form
		WebElement firstName 	 	= driver.findElement(By.id("MainContent_txtFirstName"));
		WebElement eMail		 	= driver.findElement(By.name("ctl00$MainContent$txtEmail"));
		WebElement phoneNo		 	= driver.findElement(By.id("MainContent_txtHomePhone"));
		WebElement passWord 	 	= driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPassword   = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		WebElement femaleRadio		= driver.findElement(By.id("MainContent_Female"));
		WebElement maleRadio		= driver.findElement(By.id("MainContent_Male"));
		WebElement selectCountry	= driver.findElement(By.id("MainContent_menuCountry"));
		WebElement weeklychkbox     = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlychkbox    = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement ocasschkbox  	= driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement submitButton		= driver.findElement(By.id("MainContent_btnSubmit"));
		
		firstName.sendKeys(name);
		eMail.sendKeys(email);
		phoneNo.sendKeys(phoneNumber);
		passWord.sendKeys(password);
		verifyPassword.sendKeys(password);
		// Radio buttons
		if (gender.equalsIgnoreCase("female")) { femaleRadio.click(); }
		else { maleRadio.click(); }
		//Country selection
		new Select(selectCountry).selectByVisibleText(country); ;
		
		// Checkbox algorithm
		if (weeklyEmail) {
			if (!weeklychkbox.isSelected()) {
					weeklychkbox.click();
			}
		}
		else {
			if (weeklychkbox.isSelected()) {
				weeklychkbox.click();
			}
		}
		if (monthlyEmail) {
			if (!monthlychkbox.isSelected()) {
					monthlychkbox.click();
			}
		}
		else {
			if (monthlychkbox.isSelected()) {
				monthlychkbox.click();
			}
		}
		if (occasionalEmail) {
			if (!ocasschkbox.isSelected()) {
					ocasschkbox.click();
			}
		}
		else {
			if (ocasschkbox.isSelected()) {
				ocasschkbox.click();
			}
		}
		Thread.sleep(2000);
		//submitButton.click();
		
		//4. Validate confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.contains(expected)) 
			System.out.println("Confrimation: "+conf); 
		else
			System.out.println("Test Failed");
		Thread.sleep(2000);
		
		//5. Close 
		driver.close();
		
		
				
	}

}
