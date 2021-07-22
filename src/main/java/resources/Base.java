package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	protected WebDriver driver;
	
	public Properties prop = new Properties();
	
	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Pablo\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");

		prop.load(fis);
		
		

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pablo\\Desktop\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName == "firefox") {
			// code for firefox..
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String screenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		String destination = "";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		destination = System.getProperty("user.dir")+"\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
		
	}

}
