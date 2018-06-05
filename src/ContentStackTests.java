import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContentStackTests {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setDriver() throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenuim\\chromedriver_win32\\chromedriver.exe");
		
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.contentstack.com/");
	}
	
	@Test
	public void verifyingCorrectPageIsDisplayedAndConsoleErrors() throws InterruptedException, IOException {
		setDriver();
		String ExpectedHomePageTitle = "Headless CMS Pricing | Contentstack";
		String ActualHomePageTitle = driver.getTitle();
		Assert.assertEquals(ActualHomePageTitle, ExpectedHomePageTitle);
		  
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	

	
 
}
