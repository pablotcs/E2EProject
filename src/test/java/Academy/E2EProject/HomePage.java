package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		
		Thread.sleep(3000L);
	}
	
	@Test(dataProvider = "getData")	
	public void basePageNavigation(String Username, String Pass, String text) throws IOException, InterruptedException {

		
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		LandingPage l = new LandingPage(driver);
		LoginPage lg = l.getLogin();
		lg.getEmail().sendKeys(Username);
		lg.getPassword().sendKeys(Pass);
		log.info("User: "+ text);
		
		lg.getLogin().click();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000l);
		l.getLogin();
		
		
		ForgotPassword fp = lg.forgotPassword();
		Thread.sleep(2000l);
		fp.getEmail().sendKeys("asd");
		
		fp.getSubmit().click();
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non Restricted User";
		
		return data;
	}
	

}
