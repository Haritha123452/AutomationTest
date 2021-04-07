package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL =  readconfig.getapplicationurl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String custId = readconfig.getCustID();
	public static  WebDriver driver;
	public static  Logger logger;
	public static ExtentReports report;
	public static ExtentTest log;
	
	public SimpleDateFormat simpleDate;
	String dateReport;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4J.properties");
		if(br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver= new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{

			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver= new FirefoxDriver();
		}
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss");  
	    String strDate = formatter.format(date);  
		report=new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentReportResults"+strDate+".html");
	    report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	    System.out.println("Before class");
	}
	 

	@AfterClass
	public void tearDown()
	{		
		driver.quit();	
		System.out.println("after class");

	}
	 
	 
	 
	public String captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		String errflpath = target.getAbsolutePath();
		FileUtils.copyFile(srcFile, target);
		System.out.println("Screenshot taken");
		return errflpath;
	}
	
	
}
