package Academy.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {
	
	public WebDriver driver;
	
	By searchbox = By.cssSelector("input[id='search-courses']");
	
	public portalHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getSearchbox()
	{
		return driver.findElement(searchbox);
	}

}
