package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.cssSelector("input[type='email']");
	
	By pass = By.cssSelector("input[type='password']");
	
	By log = By.cssSelector("input[type='submit']");
	
	By fp = By.cssSelector("a[class='link-below-button']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(pass);
	}
	

	public WebElement getLogin() 
	{
		return driver.findElement(log);
	}
	
	public  ForgotPassword forgotPassword()
	{
		driver.findElement(fp).click();
		
		return new ForgotPassword(driver);
		
	}
}
