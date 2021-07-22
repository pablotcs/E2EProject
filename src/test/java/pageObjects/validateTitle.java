package pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class validateTitle extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(3000L);
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		

		LandingPage l = new LandingPage(driver);

		String title = l.getTitle().getText();
		
		//No-error
		//Assert.assertEquals(title, "Featured Courses");
		
		//Error
		Assert.assertEquals(title, "Featured Courses123");
		
		//log.info("Title is fine");
		
		
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
