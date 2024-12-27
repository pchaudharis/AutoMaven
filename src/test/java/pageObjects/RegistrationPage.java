package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
    
	@FindBy (xpath="//input[@name='username']")
	WebElement UserId;
	public void UserID(String userid)
	{
		UserId.sendKeys(userid);
	}
	
	@FindBy (xpath="//input[@name='password']")
	WebElement Password;
	
	public void PassWord(String pass )
	{
		Password.sendKeys(pass);
	}
	
	@FindBy (xpath="//input[@name='repeatedPassword']")
	WebElement ConPassword;
	
	public void ConPassWord(String conpass )
	{
		ConPassword.sendKeys(conpass);
	}
	
	@FindBy (xpath="//input[@name='firstName']")
	WebElement fname;
	
	public void Fname(String name )
	{
		fname.sendKeys(name);
	}
	
	@FindBy (xpath="//input[@name='lastName']")
	WebElement lname;
	
	public void Lname(String laname )
	{
		lname.sendKeys(laname);
	}
	
	@FindBy (xpath="//input[@name='email']")
	WebElement email;
	public void Email(String mail )
	{
		email.sendKeys(mail);
	}
	
	@FindBy (xpath="//input[@name='phone']")
	WebElement phone;
	public void Phone(String phon )
	{
		phone.sendKeys(phon);
	}
	
	@FindBy (xpath="//input[@name='address1']")
	WebElement address;
	public void Address(String add )
	{
		address.sendKeys(add);
	}
	
	
	@FindBy (xpath="//input[@name='city']")
	WebElement city;
	public void City(String citi )
	{
		city.sendKeys(citi);
	}
	
	@FindBy (xpath="//input[@name='state']")
	WebElement state;
	
	public void State(String stat )
	{
		state.sendKeys(stat);
	}
	
	@FindBy (xpath="//input[@name='zip']")
	WebElement zip;
	
	public void Zip(String zipp )
	{
		zip.sendKeys(zipp);
	}
	
	@FindBy (xpath="//input[@name='country']")
	WebElement country;
	
	public void Country(String countryy )
	{
		country.sendKeys(countryy);
	}
	
@FindBy(xpath="//select[@name='languagePreference']") 
	WebElement dropdown;
public void lang()
   {
	dropdown.click();
  }
	
	
	@FindBy (name="languagePreference")
	WebElement lang;
	public  void DropDown() {
	      Select drop = new Select(lang);
	      drop.selectByIndex(3);  
	}
	
	@FindBy (name="favouriteCategoryId")
	WebElement cat;
	public  void cato() {
	      Select drop = new Select(cat);
	      drop.selectByIndex(1);  
	}
	
	@FindBy(name="listOption")
	WebElement Mylist;
	public void check()
	   {
		Mylist.click();
	  }
	
	@FindBy(name="bannerOption")
	WebElement Mybanner;
	public void checkbox()
	   {
		Mybanner.click();
	  }
	@FindBy(xpath="//button[normalize-space()='Save Account Information']")
	WebElement Save;
	public void submit()
	   {
		Save.click();
	  }
}
