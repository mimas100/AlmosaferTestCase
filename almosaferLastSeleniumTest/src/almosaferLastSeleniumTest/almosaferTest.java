package almosaferLastSeleniumTest;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v125.storage.model.AttributionReportingSourceRegistrationTimeConfig;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class almosaferTest extends global {

	
	@BeforeTest
	
	public void mySetup(){
		generalSetup();
		
	}
	
	
	@Test(priority = 1)
	
	public void checkifEnglishLanguage() throws InterruptedException
	{
		String appLanguage= driver.findElement(By.tagName("html")).getAttribute("lang");
		 
		//WebElement EnglishLanguage = driver.findElement(By.linkText("English"));
	    //WebElement EnglishLanguage = driver.findElement(By.cssSelector(".sc-gkFcWv.hcOfTd"));
		//Thread.sleep(3000);
		String ActualLang = appLanguage;
		
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

		Assert.assertEquals(ActualPhone, ExpPhone);	
		
	}
	

	@Test(priority = 4)
	public void checkQitafLogo()
	{
		WebElement qitafLogo = driver.findElement(By.cssSelector(".sc-fihHvN.eYrDjb"));
		boolean actualLogo = qitafLogo.isDisplayed();
		
		Assert.assertEquals(actualLogo, expLogo);
			
	}
	
	@Test(priority = 5)
	public void checkifHotelSelected()
	{
		WebElement hotelSelected = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String actualhotelSelected = hotelSelected.getAttribute("aria-selected");
		
		Assert.assertEquals(actualhotelSelected, expectedhotelSelected);
		
	}
	
	@Test(priority = 6)
	public void checkDepartureAndReturnDate()
	{
		
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
		changeURLCalss();
	}
	
	@Test (priority = 8 )
	public void searchSection()
	{
		 
		WebElement hotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelTab.click();
		
		WebElement country = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
		
		String appLanguage= driver.findElement(By.tagName("html")).getAttribute("lang");
		
		
		
		if(appLanguage.contains("en"))
		{
			
			
			country.sendKeys(randomCountry);
		}
		if(appLanguage.contains("ar"))
		{
			
			  country.sendKeys(randomCountry);
		}
		
		
		WebElement listOfLocations = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
		 WebElement firstLocation = listOfLocations.findElements(By.tagName("li")).get(1);
		 firstLocation.click();
		 
	}
	
	@Test(priority = 9)
	public void numberOfVisitors()
	{
		
		WebElement selectorVisitor = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		
		Select select = new Select(selectorVisitor);
		
		// select by value
		//select.selectByValue("B");
		
		
		// select by index 
		int randomIndex = random.nextInt(2);
		select.selectByIndex(randomIndex);
		
		// select by visable
/*String appLanguage= driver.findElement(By.tagName("html")).getAttribute("lang");
		
		
		if(appLanguage.contains("ar"))
		{
		
		select.selectByVisibleText("غرفة واحدة، 2 بالغون، 0 أطفال");
		}
		else
		
		
		if(appLanguage.contains("en"))
		{
			select.selectByVisibleText("1 Room, 2 Adults, 0 Children");
		}
		*/
		WebElement searchHotelClick = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		searchHotelClick.click();
		
	}
	
	@Test (priority = 10)
	public void assertOfREsult() throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement ResultPage = driver.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']"));
		String resultLoaded = ResultPage.getText();
		
		Boolean result = resultLoaded.contains("found") || resultLoaded.contains("وجدنا");
		Assert.assertEquals(result, ExpectedResult);
		
	
	}
	
	@Test (priority = 11)
	public void lowestHotelPrice()
	{
		WebElement lowestPrice = driver.findElement(By.xpath("//button[@data-testid='HotelSearchResult__sort__LOWEST_PRICE']"));
		lowestPrice.click();
		
		WebElement ALLpricesContianer = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));
		
		List <WebElement> prices = ALLpricesContianer.findElements(By.className("Price__Value"));
		
		
		String LowestPrice = prices.get(0).getText();
		String HighestPrice = prices.get(prices.size()-1).getText();
		
		int lowestASInt = Integer.parseInt(LowestPrice);
		int HighestASInt = Integer.parseInt(HighestPrice);
		
		Boolean actual = lowestASInt<HighestASInt;
		
		Assert.assertEquals(actual, expexted);
		
				
		
	}
}
