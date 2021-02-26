package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerpage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCust_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		driver.get(baseURL);
		logger.info("browser opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUSername(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
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
		logger.info("clicked on customer");
		addcust.setCustomerName("abcd");
		logger.info("cust name  provided");
		addcust.setradioGender("female");
		logger.info("Gender provided");
		
		
	}

}
