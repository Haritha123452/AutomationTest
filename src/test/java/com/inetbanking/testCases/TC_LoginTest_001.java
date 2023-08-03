package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test(enabled = true)
	public void loginTest() throws IOException {

		try {

			String testCaseNAme = "Login Test";
			test = extent.createTest("Test Case 1", "PASSED test case");
			driver.get(baseURL);
			logger.info("browser opened");
			LoginPage lp = new LoginPage(driver);
			lp.setUSername(username);
			logger.info("username provided");
			lp.setPassword(password);
			logger.info("password provided");

			lp.clickSubmit();
			logger.info("clicked on submit button");

			if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				Assert.assertTrue(true);

			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
