package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigation extends Base{
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initilizeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test

	public void basePageNavigationTest() throws IOException
	{		
		LandingPage ln= new LandingPage(driver);
		
		Assert.assertTrue(ln.getNavigationBar().isDisplayed()); 
		log.info("Navigation Bar is displayed");
			
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
