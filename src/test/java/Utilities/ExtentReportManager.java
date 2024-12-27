package Utilities;


	import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
    import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

    import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
     import com.aventstack.extentreports.reporter.configuration.Theme;

     import testCases.BaseClassT;
	public class ExtentReportManager implements ITestListener{
	  
		public ExtentSparkReporter sparkReporter;
		public ExtentReports extent ;
		public ExtentTest test;
		
		String repName;
		private CharSequence includedGroups;
		public void onStart(ITestContext testContext)
		{
//			SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.ss");
//		Date dt =new Date();
//		String crrentdatetimestamp=df.format(dt);
			
			String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			repName="Test-Report-"+timeStamp+".html";
			sparkReporter=new ExtentSparkReporter (".\\reports\\"+repName);
			sparkReporter.config().setDocumentTitle("opencart Automation Report");//Tile of the report
			sparkReporter.config().setReportName("Jpet Store"); //Name of the report
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application","Jpet store");
			extent.setSystemInfo("Module","Admin");
			extent.setSystemInfo("Sub Module","Customers");
			extent.setSystemInfo("User Nmae", System.getProperty("user.name"));
			extent.setSystemInfo("Environment","QA");
			
			String os=testContext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System", os);
			
			String browser=testContext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);
			List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
			if (!includedGroups.isEmpty())
			{
				extent.setSystemInfo("Groups",includedGroups.toString());
			}
			
		}
				
		public void onTestSuccess(ITestResult result)
		{
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups()); //to display groups in reports
			test.log(Status.PASS,result.getName()+"got successfully excuted");
		}
			
			
		public void onTestFailure(ITestResult result)	
		{
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL,result.getName()+"get failed");
			test.log(Status.INFO,result.getThrowable().getMessage());
			
			try {
				String imgPath=new BaseClassT().captureScreen(result.getName());  //
				test.addScreenCaptureFromPath(imgPath);
			}
			catch(IOException e1) {
				e1. printStackTrace();
			}
			
		}
			
		public void onTestSkipped(ITestResult result)	
		{
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getTestClass().getName());
			test.log(Status.SKIP,result.getName()+"got skipped");
			test.log(Status.INFO,result.getThrowable().getMessage());
			
			
		}
		
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
			
			String pathOfExtentReport=System.getProperty("user.dir")+"reports\\"+repName;
			File extentReport=new File(pathOfExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
		
	}



	

