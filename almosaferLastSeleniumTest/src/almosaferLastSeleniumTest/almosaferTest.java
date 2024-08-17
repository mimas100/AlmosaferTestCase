package almosaferLastSeleniumTest;

import java.sql.Driver;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v125.storage.model.AttributionReportingSourceRegistrationTimeConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class almosaferTest {
	
	WebDriver driver = new ChromeDriver();
	String webSite = "https://www.almosafer.com/en";
	Random random = new Random();
	
	
	@BeforeTest
	
	public void mySetup(){
		driver.get(webSite);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 

		WebElement KingdomKSA = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		KingdomKSA.click();
		
		
		
		
		
	}
	@Test(priority = 1)
	
	public void checkifEnglishLanguage() throws InterruptedException
	{
		
		//WebElement EnglishLanguage = driver.findElement(By.linkText("English"));
	    //WebElement EnglishLanguage = driver.findElement(By.cssSelector(".sc-gkFcWv.hcOfTd"));
		//Thread.sleep(3000);
		String EnglishLanguage= driver.findElement(By.tagName("html")).getAttribute("lang");
		String ActualLang = EnglishLanguage;
		String ExceptedLang = "en";
		
		Assert.assertEquals(ActualLang, ExceptedLang);
		
		//WebElement ArabicLanguage = driver.findElement(By.cssSelector(".sc-gkFcWv.jJNggu"));
		//Thread.sleep(3000);
		//String ActualLangar = ArabicLanguage.getText();
		//String ExceptedLangar = "العربية";
		
		//Assert.assertEquals(ActualLangar, ExceptedLangar);
				
		
	}
	
	@Test (priority = 2)
	public void checkifcurrencySAR() {
		
		WebElement currency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
		String ActualCurrency = currency.getText();
		
        String ExpCurrency = "SAR";
        Assert.assertEquals(ActualCurrency, ExpCurrency);
	}
	
	@Test(priority = 3)
	public void checkifCorrectPhone()
	{
		WebElement phoneNum = driver.findElement(By.tagName("strong"));
		String ActualPhone = phoneNum.getText();
		String ExpPhone = "+966554400000";
		
		Assert.assertEquals(ActualPhone, ExpPhone);	
		
	}
	

	@Test(priority = 4)
	public void checkQitafLogo()
	{
		WebElement qitafLogo = driver.findElement(By.cssSelector(".sc-fihHvN.eYrDjb"));
		boolean actualLogo = qitafLogo.isDisplayed();
		boolean expLogo = true;
		
		Assert.assertEquals(actualLogo, expLogo);
			
	}
	
	@Test(priority = 5)
	public void checkifHotelSelected()
	{
		WebElement hotelSelected = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String actualhotelSelected = hotelSelected.getAttribute("aria-selected");
		String expectedhotelSelected = "false"; 
		
		Assert.assertEquals(actualhotelSelected, expectedhotelSelected);
		
	}
	
	@Test(priority = 6)
	public void checkDepartureAndReturnDate()
	{
		LocalDate TodayDate = LocalDate.now();
		
		System.out.println(TodayDate);
		int Today = TodayDate.getDayOfMonth();
		System.out.println(Today);
		
		
		int departureDate = TodayDate.plusDays(1).getDayOfMonth();
		int returnDate = TodayDate.plusDays(2).getDayOfMonth();
		
		//int departureDate = Today+1;
	   //int returnDate = Today+2;
		
	List<WebElement> DepartureAndReturnDate = driver.findElements(By.className("LiroG"));
	String ActdepartureDate = DepartureAndReturnDate.get(0).getText();
	String ActReturnDate = DepartureAndReturnDate.get(1).getText();
	
	int ActualDeparture = Integer.parseInt(ActdepartureDate);
	int ActualReturn = Integer.parseInt(ActReturnDate);
	
	Assert.assertEquals(ActualDeparture, departureDate);
	Assert.assertEquals(ActualReturn, returnDate);
		
	}
	
	
	@Test(priority = 7)
	public void changeURL()
	{
		String [] urls = {"https://www.almosafer.com/en" ," https://www.almosafer.com/ar"};
		int randomURL = random.nextInt(urls.length);
		
		driver.get(urls[randomURL]);
			
	}
}
