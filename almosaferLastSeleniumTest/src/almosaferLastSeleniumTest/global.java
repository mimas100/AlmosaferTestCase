package almosaferLastSeleniumTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class global {

	
	WebDriver driver = new ChromeDriver();
	String webSite = "https://www.almosafer.com/en";
	String appLanguage= driver.findElement(By.tagName("html")).getAttribute("lang");
 
	Random random = new Random();
	String ExceptedLang = "en";
	String ExpPhone = "+966554400000";
	boolean expLogo = true;
	String expectedhotelSelected = "false"; 
	LocalDate TodayDate = LocalDate.now();

		Boolean ExpectedResult = true;
	Boolean expexted = true;
	
	String[] Location = {"Dubai","Jedda","Riyada"};
	int randomCountryIndex = random.nextInt(Location.length);
	String randomCountry = Location[randomCountryIndex];
	

	String[] LocationArabic = {"جدة","الرياض"};
	int randomCountryIndexArabic = random.nextInt(Location.length);
	String randomCountryArabic = Location[randomCountryIndex];

	
	
	int randomIndex = random.nextInt(2);
	
	public void generalSetup() {
		driver.get(webSite);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 

		WebElement KingdomKSA = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		KingdomKSA.click();
		
	}
	
	public void changeURLCalss() {
	String [] urls = {"https://www.almosafer.com/en" ," https://www.almosafer.com/ar"};
	int randomURL = random.nextInt(urls.length);
	
	driver.get(urls[randomURL]);
	}
	
		
	
	
}
