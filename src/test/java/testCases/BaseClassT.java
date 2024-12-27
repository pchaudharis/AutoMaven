package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClassT {
public static WebDriver driver; // make static webdriver 
public Logger logger;//Log4j
public Properties p;
@BeforeClass(groups= {"Sanity","Regression","Master"})
@Parameters({"os","browser"})
	
	public void Setup(String os, String br) throws IOException
	{
		//Loading config.properties file
				FileReader file=new FileReader("./src\\test\\resources\\config.properties");
				p=new Properties();
				p.load(file);
				
				
				
				//logger=(Logger) LogManager.getLogger(this.getClass());  //log4j2
				logger=LogManager.getLogger(this.getClass());
				switch(br.toLowerCase())
				{
				case "chrome": driver=new ChromeDriver(); break;
				case "edge" : driver=new EdgeDriver(); break;
				case "firefox" : driver=new FirefoxDriver(); break;
				default: System.out.println("Invalid browser name...");return;
				}

		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jpetstore.aspectran.com/");
	    driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	 
	public String randomnumber()
	{
		String generatednum=RandomStringUtils.randomNumeric(10);
		return generatednum;
	}
	
	public String randomAlphanumric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednum=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednum);
	}
	
	
	public String captureScreen(String tname)throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath =System.getProperty("user.dir")+"\\screenshots\\"+tname+ "-"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	}
//	public static void screenshot(WebDriver driver, long ms)
//	{
//
//	try {
//	    TakesScreenshot ts = (TakesScreenshot) driver;
//	    File source = ts.getScreenshotAs(OutputType.FILE);
//	    FileUtils.copyFile(source, new File("./ScreenShots/"+ms+"Facebook.png"));
//	    System.out.println("ScreenShot Taken");
//	} 
//	catch (Exception e) 
//	{
//	    System.out.println("Exception while taking ScreenShot "+e.getMessage());
//	}


	//}
	
}
