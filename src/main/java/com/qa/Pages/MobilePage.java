package com.qa.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	
	public void Verify_imgs_and_broken_links() {
		List <WebElement> links =driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		
		List <WebElement>ActiveLinks =new ArrayList <WebElement>();
		
		for (int i=0; i<links.size();i++) {
			if(links.get(i).getAttribute("href")!=null) {
				ActiveLinks.add(links.get(i));
			}
			
		}
		System.out.println("all links " +links.size());
		System.out.println("Active links " +ActiveLinks.size());
		for (int j=0;j<links.size();j++) {
			System.out.println(links.get(j).getText());
		}
		
	}

}
