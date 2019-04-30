package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MobilePage extends BaseTestClass{
	@FindBy (xpath ="//select[@title='Sort By']")
	WebElement SortIcon;
	
	@FindBy (xpath="//a[@class='Set Ascending Direction']")
	WebElement AscendingBtn;
	
	@FindBy(xpath="//div[@class='count-container']//p[@class='amount amount--no-pages']")
	WebElement ItemsInPage;
	
	public MobilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String Verify_sort() {
		Select sel=new Select(SortIcon);
		sel.selectByVisibleText("Name");
		return ItemsInPage.getText();
	}

}
