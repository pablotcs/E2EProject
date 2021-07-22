package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	
	By email = By.cssSelector("input[type='email']");
	
	By submit = By.cssSelector("input[type='submit']");
	
	
	public ForgotPassword(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	
	

}
