package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//BASE CLASS TO INSTANTIATE THE DRIVER
public class Base {
		
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initilizeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\rjm20\\OneDrive\\Documents\\A_A-SELENIUM_CLASS\\E2Eproject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(file);
		String browsername= prop.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:/webdriver/geckodriver.exe");
			driver = new FirefoxDriver();	
			driver.manage().window().maximize();
		}
		else if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:/webdriver/update/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browsername.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:/webdriver/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		return driver;			
	}
	
	//TAKING A SCREEN SHOT OF ANY FAILED TEST
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
