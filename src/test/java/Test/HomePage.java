package Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initilizeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigationTest(String username, String password, String text) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		LandingPage lnd = new LandingPage(driver);			
		LoginPage lp = lnd.getLogin();	
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);	
		log.info(text);
		lp.getLogin().click();
		ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().sendKeys("ramrs2@gmail.com");
		fp.sendInstruction().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//column stands for how many values do you want to send per test
		Object[][] data= new Object[2][3];
		data[0][0]="nonrestricteduser@com";
		data[0][1]="tongasoa";		
		data[0][2]="Restricted User";
		
		data[1][0]="restricteduser@com";
		data[1][1]="sdfasf"; 
		data[1][2]="Non restricted user"; 
		
		return data;
	}
	
	
}
