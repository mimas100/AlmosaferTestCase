package secondTestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myLoginTestCases {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void mysetup() {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		
	}
	

	@Test(priority = 1)
	
	public void loginTest()  
	     {
		
		String userName= "standard_user";
		String password= "secret_sauce";
		
		WebElement inputUserName = driver.findElement(By.id("user-name"));
		WebElement inputPassword = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		
		inputUserName.sendKeys(userName);
		inputPassword.sendKeys(password);
		loginButton.click();
		
        	}
	
	@Test(priority = 2)
	public void addToCardItemes() {
	
	List <WebElement> addtoCardButton = driver.findElements(By.className("btn"));
	
	for(int i=0 ; i<addtoCardButton.size();i++)
	{  
		
		if (i<4) {
		addtoCardButton.get(i).click();
		}
		
		
		
	}
	

	
	}
	
	
	
	

}
