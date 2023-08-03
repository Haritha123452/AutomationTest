package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_EditCustomer extends BaseClass {

	/*
	 * @Author - Santhosh Description - This test case edits customer details based
	 * on the customer id
	 * 
	 */
	@Test
	public void editCustomer() throws InterruptedException, IOException {

		// Logging to Guru99 website
		logger.info("browser opened");
		driver.get(baseURL);
		String testCaseName = "Edit cusomer Details";
		test = extent.createTest("Test Case 2", "PASSED test case");
		LoginPage lp = new LoginPage(driver);
		lp.setUSername(username);

		logger.info("username provided");
		lp.setPassword(password);

		logger.info("Password provided");
		lp.clickSubmit();

	}

}
