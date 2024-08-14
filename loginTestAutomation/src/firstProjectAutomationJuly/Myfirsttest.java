package firstProjectAutomationJuly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Myfirsttest {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	
	public void mysetup() {
	     driver.manage().window().maximize();
         driver.get("http://127.0.0.1:5500/index.html");
                      }
	@Test 
	
	public void loginTest
	{}
	
}