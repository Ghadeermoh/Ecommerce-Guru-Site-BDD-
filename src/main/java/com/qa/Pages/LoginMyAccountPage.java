package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMyAccountPage extends BaseTestClass{
	
	@FindBy (xpath="//a[@class='skip-link skip-account']")
	WebElement AccountIcon;
	
	@FindBy(xpath="//a [contains(text(),'My Account')]")
	WebElement MyAcountLink;
	
	@FindBy(id="email")
	WebElement EmailField;
	
	@FindBy (id="pass")
	WebElement Passfield;
	
	@FindBy (id="send2")
	WebElement LoginBtn;
	public LoginMyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String Verify_open_LoginMyAcc_Page() {
		AccountIcon.click();
		MyAcountLink.click();
		return driver.getTitle();
	}
	
	public void Verify_Login(String username ,String password) {
		EmailField.sendKeys(username);
		Passfield.sendKeys(password);
		LoginBtn.click();
	}
	
	

}
