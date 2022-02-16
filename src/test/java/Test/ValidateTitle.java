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

public class ValidateTitle extends Base {
	/*****
	 * Declare a local variable for driver so it doesn't point to the driver in the Base class
	 * that way there is no conflict when running the test in parallel
	 */
	public WebDriver driver;
	
	public static Logger log= LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initilizeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to Home page");
	}

	@Test
	public void basePageNavigationTest() throws IOException
	{
		LandingPage l= new LandingPage(driver);
		
		//COMPARE THE TEXT FROM THE BROWSER WITH THE ACTUAL TEXT GIVEN
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES 201");	
		log.info("Succesfully validated text message");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
