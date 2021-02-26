package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerpage {
	WebDriver ldriver;
	public AddCustomerpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		ldriver.findElement(By.linkText("addcustomerpage.php"));
		//updated comments
		//comment
	}
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a") WebElement linkNewCustomer;
	public void clickNewCustomer()
	{
		linkNewCustomer.click();
	}
	@FindBy(name="name") WebElement txtCustomerName;
	public void setCustomerName(String custName)
	{
		txtCustomerName.sendKeys(custName);
	}
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]") WebElement radioGender;
	public void setradioGender(String gender)
	{
		radioGender.sendKeys(gender);
	}
	@FindBy(linkText = "addcustomerpage.php") WebElement txtDateofBirth;
	@FindBy(linkText = "addcustomerpage.php") WebElement txtAddress;
	@FindBy(linkText = "addcustomerpage.php") WebElement txtCity;
	@FindBy(linkText = "addcustomerpage.php") WebElement txtPIN;
	@FindBy(linkText = "addcustomerpage.php") WebElement txtState;
	

}
