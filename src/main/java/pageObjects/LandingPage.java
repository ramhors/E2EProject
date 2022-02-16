package pageObjects;

import org.openqa.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin =By.cssSelector("a[href*='sign_in']");
	//By signin = By.linkText("Login");
	By title= By.xpath("//h2[contains(text(),'Featured Courses')]");
	By nav = By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage getLogin()
	{
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(nav);
	}
}
