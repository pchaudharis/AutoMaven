package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Sign In']")
	WebElement signin;
	public void Signin()
	{
		signin.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Register Now!']")
	WebElement registernow;
	
	public void Registernow()
	{
		registernow.click();
	}
}

