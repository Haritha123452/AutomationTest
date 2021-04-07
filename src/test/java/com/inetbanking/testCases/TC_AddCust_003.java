package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerpage;
import com.inetbanking.pageObjects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC_AddCust_003 extends BaseClass {
	

	/*
	 * @Author - Santhosh
	 * Description - Added new customer details.
	 * 
	 */
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		 
		String testCaseNAme = "Add NeW Customer";
		log=report.startTest(testCaseNAme);
		driver.get(baseURL);
		//logger.info("browser opened");
		log.log(LogStatus.PASS,"Step1 Passed");
		LoginPage lp = new LoginPage(driver);
		lp.setUSername(username);
		logger.info("username provided");
		log.log(LogStatus.PASS,"Step2 Passed");
		report.endTest(log);
		report.flush();
		log=report.startTest("Edit NeW Customer");
		lp.setPassword(password);
		logger.info("password provided");
	    log.log(LogStatus.FAIL,"Step3 Failed");
	  	log.log(LogStatus.FAIL,log.addScreenCapture(captureScreen(driver,testCaseNAme))+"test failed");
		lp.clickSubmit();
		logger.info("clicked on submit button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		AddCustomerpage addcust = new AddCustomerpage(driver);
		addcust.clickNewCustomer();
		logger.info("clicked on New customer link");
		addcust.setCustomerName("abcd");
		logger.info("cust name  provided");
		addcust.setradioGender("female");
		logger.info("Gender provided");
		Thread.sleep(3000);
		addcust.txtDOB();
		logger.info("Date provided");
		addcust.addAddress("abcdefs");		
	 	logger.info("Address provided");
		addcust.addCity("cityabcdefs");		
		logger.info("City provided");
		addcust.addPIN("123456");		
		logger.info("PIN  provided");
		addcust.clickSubmit();
     	logger.info("clicked on Submit");
		addcust.getTextfromalert();
		report.endTest(log);
		report.flush();
		report.close(); 
	}
    
	/*
	 * @Author - Santhosh
	 * Description - Edit the customer details.
	 * 
	 */
	@Test(enabled = false)
    public void editCustomer() {
		
		
		
	}
    
    
}
