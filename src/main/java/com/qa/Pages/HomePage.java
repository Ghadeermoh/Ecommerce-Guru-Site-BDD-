package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTestClass{
	
	@FindBy(xpath ="//a[contains(text(),'Mobile')]")
	WebElement MobileIcon;
	
	@FindBy(xpath="//a[contains(text(),'TV')]")
	WebElement TVIcon;
	
	@FindBy(xpath="//img[contains(text(),'Magento Commerce')]")
	WebElement HomeLogo;
	
	@FindBy (id="search")
	WebElement SearchIcon;
	
	@FindBy (xpath="//button[@title='Search']")
	WebElement SearchBtn;
	
	@FindBy (xpath="//img[contains(text(),'IPhone')]")
	WebElement Iphone;
	
	@FindBy(xpath="//div[@class='count-container']//p[@class='amount amount--no-pages']")
	WebElement ItemsInPage;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String  Verify_home_title() {
		return driver.getTitle();
		
	}
	public String  Verify_mobile_icon() {
		MobileIcon.click();
		return driver.getTitle();
		
	}
	
	public String Verify_TV_icon() {
		TVIcon.click();
		return driver.getTitle();
	}
	
	public String  Verify_search() {
		SearchIcon.sendKeys("Mobile");
		SearchBtn.click();
		return ItemsInPage.getText();
		
	}
	

}
