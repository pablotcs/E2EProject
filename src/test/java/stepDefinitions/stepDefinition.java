package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Academy.E2EProject.portalHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;


public class stepDefinition extends Base{

	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
		
		driver = initializeDriver();
	}
	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
	    
		driver.get(string);
		
	}
	@Given("Click on Login link in home page to land on Secure sign in page")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {

		LandingPage l = new LandingPage(driver);
		l.getLogin();
	}
	@When("User enters {string} and {string} and logs in")
	public void user_enters_and_and_logs_in(String string, String string2) {
		LoginPage lg = new LoginPage(driver);
		lg.getEmail().sendKeys(string);
		lg.getPassword().sendKeys(string2);
		
		lg.getLogin().click();
	}
	@Then("Verify that user is succesfully logged in")
	public void verify_that_user_is_succesfully_logged_in() {
		
		portalHomePage hp = new portalHomePage(driver);
		Assert.assertTrue(hp.getSearchbox().isDisplayed());
		
	}

}
