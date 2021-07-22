package pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class validateNavBar extends Base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		log.info("Driver is initialize");
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to HomePage");
		
		Thread.sleep(3000L);
	}
	
	@Test
	public void basePageNavigation() throws IOException {

		LandingPage l = new LandingPage(driver);
		
		WebElement bar = l.getNavigationBar();

		Assert.assertTrue(bar.isDisplayed());
		
		log.info("NavBar is displayed");
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	

}
