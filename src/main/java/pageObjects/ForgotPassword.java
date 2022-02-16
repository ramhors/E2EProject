package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	
	public ForgotPassword(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	By email = By.id("user_email");
	By sendMeInstuctions = By.xpath("//input[@type='submit']");
	
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendInstruction()
	{
		return driver.findElement(sendMeInstuctions);
	}
}
