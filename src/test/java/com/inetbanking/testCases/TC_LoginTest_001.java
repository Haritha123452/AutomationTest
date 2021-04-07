package com.inetbanking.testCases; 

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test(enabled=true)
	public void loginTest() throws IOException
	{
		 
		
		try {
			    
			    String testCaseNAme = "Login Test";
				log=report.startTest(testCaseNAme);				 
				driver.get(baseURL);
				logger.info("browser opened");
				log.log(LogStatus.PASS,"browser opened");
				LoginPage lp = new LoginPage(driver);
				lp.setUSername(username);
				logger.info("username provided");
				log.log(LogStatus.PASS,"username provided");
				lp.setPassword(password);
				logger.info("password provided");
				log.log(LogStatus.PASS,"password provided");
				lp.clickSubmit();
				logger.info("clicked on submit button");
				log.log(LogStatus.PASS,"clicked on submit button");
				if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
				{
					Assert.assertTrue(true);
					log.log(LogStatus.PASS,log.addScreenCapture(captureScreen(driver,testCaseNAme)),"Login Test");
					report.endTest(log);
					report.flush();
					
				}
				else
				{
					Assert.assertTrue(false);
					log.log(LogStatus.FAIL,"Login Test");
				}
				}
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		 
	}

}
