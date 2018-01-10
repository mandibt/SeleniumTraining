package demos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Expedia {
	
	WebDriver driver;
	String browserType = "chrome";
	String city = "Chicago, IL";
	String checkInDate = "02/20/2018";
	String checkOutDate = "02/25/2018";
	String numOfGuests = "2";
	String starRating = "4";
	
	@Test
	public void hotelReservation ( ) throws InterruptedException {
		//1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkInDate);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOutDate);
		new Select(driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[4]/label/select"))).selectByValue(numOfGuests);
		driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[9]/label/button")).click();
		Thread.sleep(10000);
		//Assert we are in the right city
		String actualCity = driver.findElement(By.xpath("//*[@id=\'hotelResultTitle\']/h1")).getText();
		System.out.println("CITY: " + actualCity);
		
		//2. Modify search results, give criteria
		driver.findElement(By.cssSelector("input[name='star'][id='star"+starRating+"']")).click();
		Thread.sleep(5000);
		
		//3. Analyze results and make selection
		driver.findElement(By.xpath("//*[@id=\'resultsContainer\']/section/article[3]")).click();
		Thread.sleep(5000);
		//4. Book
		
		//5. Fill out contact form
		
		//6. Get confirmation
		
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.driverFactory.openBrowser(browserType);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
	}
	
	@AfterMethod 
	public void tearDown() {
		//driver.quit();
	}
}
