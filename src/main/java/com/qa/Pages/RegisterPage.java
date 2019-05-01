package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseTestClass {
	
	 
  @FindBy (xpath="//div[@class='links']//li/descendant::a[@title='Register']")
  WebElement RegisterLink;
	
	@FindBy (xpath="//a[@class='skip-link skip-account']")
	WebElement AccountIcon;
	@FindBy (id="firstname")
	WebElement Firstname;
	
	@FindBy (id="lastname")
	WebElement Lasttname;
	
	@FindBy (id="email_address")
	WebElement Email;
	
	@FindBy (id="password")
	WebElement Password;
	
	@FindBy (id="confirmation")
	WebElement Confirmpass;
	
	@FindBy (xpath="//button[@title='Register']")
	WebElement registerBtn;
	
	
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Verify_register_opening() {
		AccountIcon.click();
		RegisterLink.click();
		
	}
	public String Verify_RegPage_Title() {
		return driver.getTitle();
	}
	public void Verify_new_customer_register(String Fn ,String Ln,String mail ,String Pass ,String confPass ) {
		
		Firstname.sendKeys(Fn);
		Lasttname.sendKeys(Ln);
		Email.sendKeys(mail);
		Password.sendKeys(Pass);
		Confirmpass.sendKeys(confPass);
		registerBtn.click();
		
	}

}
