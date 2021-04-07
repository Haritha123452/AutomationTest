package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerpage {
	//Foourth Commit 
	WebDriver ldriver;
	public AddCustomerpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath="//a[contains(text(),'New Customer')]") WebElement linkNewCustomer;
	public void clickNewCustomer()
	{
		linkNewCustomer.click();	
	}
	@FindBy(name="name") WebElement txtCustomerName;
	public void setCustomerName(String custName)
	{
		txtCustomerName.sendKeys(custName);
	}
	@FindBy(name="rad1") WebElement radioGender;
	public void setradioGender(String gender)
	{
		radioGender.click();
	}
	@FindBy(id="dob") WebElement txtDateofBirth;
	public void txtDOB()
	{
		txtDateofBirth.sendKeys("11");
		txtDateofBirth.sendKeys("11");
		txtDateofBirth.sendKeys("1991");
	}
	@FindBy(xpath = "//*[@name='addr']") WebElement txtAddress;
	public void addAddress(String address)
	{
		txtAddress.sendKeys(address);
	}
	@FindBy(xpath = "//input[@name='city']") WebElement txtCity;
	public void addCity(String city)
	{
		txtCity.sendKeys(city);
	}
	@FindBy(linkText = "//*[@type ='text' and @name ='state']") WebElement txtState;
	public void addState(String state)
	{
		txtState.sendKeys(state);
	}
	@FindBy(xpath = "//*[@type ='text' and @name ='pinno']") WebElement txtPIN;
	public void addPIN(String pin)
	{
		txtPIN.sendKeys(pin);
	}
	
	@FindBy(name="sub") WebElement btnclickSubmit;
	public void clickSubmit()
	{
		btnclickSubmit.click();
	}
	public void getTextfromalert()
	{
		System.out.println(ldriver.switchTo().alert().getText());
	}

}
