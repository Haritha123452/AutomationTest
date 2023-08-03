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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getapplicationurl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String custId = readconfig.getCustID();
	public static WebDriver driver;
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static SimpleDateFormat simpleDate;
	String dateReport;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4J.properties");
		if (br.equals("chrome")) {
			
			String path=readconfig.getChromePath();
			//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
	        WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
		} else if (br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss");
		String strDate = formatter.format(date);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\test-output\\ExtentReportResults" + strDate + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// report.loadConfig(new
		// File(System.getProperty("user.dir")+"\\extent-config.xml"));
		// To add system or environment info by using the setSystemInfo method.
		// extent.setSystemInfo("OS", OS);
		// extent.setSystemInfo("Browser", browser);

		// configuration items to change the look and feel
		// add content, manage tests etc
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		System.out.println("Before class");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("after class");

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	public String captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		String errflpath = target.getAbsolutePath();
		FileUtils.copyFile(srcFile, target);
		System.out.println("Screenshot taken");
		return errflpath;
	}

	@AfterTest
	public void afterTest() {
		// to write or update test information to reporter
		extent.flush();
	}
}
