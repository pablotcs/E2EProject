package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By SignIn = By.cssSelector("a[href='https://courses.rahulshettyacademy.com/sign_in']");

	By title = By.xpath("//div[@class = 'pull-left']/h2");
	
	By navBar = By.cssSelector("ul[class='navigation clearfix']");
	
	

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(SignIn).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	
	
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
}
