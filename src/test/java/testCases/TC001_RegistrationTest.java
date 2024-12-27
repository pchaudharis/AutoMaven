package testCases;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC001_RegistrationTest extends BaseClassT{
//public	utility Utility;
	//public WebDriver driver;
	//public static Logger log;
@Test()
public void Registration()
{
	final Logger logger = LogManager.getLogger(TC001_RegistrationTest.class);
	
	HomePage hp =new HomePage(driver);
	logger.info("****Jpet Store****");	
			hp.Signin();
			hp.Registernow();
			logger.info("****Registration Started****");	
    RegistrationPage reg=new RegistrationPage(driver);
    reg.UserID(randomnumber());
    String password=randomAlphanumric();
    reg.PassWord(password);
    reg.ConPassWord(password);
    reg.Fname(randomstring().toUpperCase());
    reg.Lname(randomstring().toUpperCase());
    reg.Email(randomstring()+"@gmail.com");
    reg.Phone(randomnumber());
    reg.Address(randomstring().toUpperCase()+"123");
    reg.City("pune");
    reg.State("Maharashtra");
    reg.Zip("411033");
    reg.Country("INDIA");
 
    reg.DropDown();
    reg.cato();
    reg.check();
    reg.checkbox();
    reg.submit();
   //System.out.println("Registration successfully completed.");
   logger.info("****Registration successfully completed.****");	
   
  
//Utility.screenshot(driver, System.currentTimeMillis());
    
}

    
}



