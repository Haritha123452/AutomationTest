package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;



public class TC_EditCustomer extends BaseClass{
	
	/*
	 * @Author - Santhosh
	 * Description - This test case edits customer details based on the customer id 
	 * 
	 */
	@Test	
	public void editCustomer() throws InterruptedException, IOException {
		
		//Logging to Guru99 website
		logger.info("browser opened");
		driver.get(baseURL);
		String testCaseName="Edit cusomer Details";
		log=report.startTest(testCaseName);
		log.log(LogStatus.PASS, "browser opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUSername(username);
		
		log.log(LogStatus.PASS, "Username provided");
		logger.info("username provided");
		lp.setPassword(password);
		log.log(LogStatus.PASS, "Password provided");
		logger.info("Password provided");
		lp.clickSubmit();		
		//Creating object of Edit Customer Page 
		EditCustomerPage editCustomer = new EditCustomerPage(driver);
		//clicking Edit button
		editCustomer.clicklinkEditCusomer();
		//Providing cust id 
		editCustomer.textcustID(custId);
		//clicking on submit
		editCustomer.clickSubmitButton();
		log.log(LogStatus.PASS,log.addScreenCapture(captureScreen(driver,testCaseName)));
		report.endTest(log);
		report.flush();
		report.close(); 
		
	}
	

}
