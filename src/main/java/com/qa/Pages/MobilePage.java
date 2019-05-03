package com.qa.Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button/span/span")
	WebElement AddtoCart1st;
	
	@FindBy (xpath="//input[@title='Qty']")
	WebElement QTY;
	
	@FindBy (xpath="//button[@title='Update']")
	WebElement UpdateCart;
	
	@FindBy(xpath="//a[contains(text(),'Add to Compare')]")
	WebElement AddtoCompare1;
	
	@FindBy (xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")
	WebElement Addtocompare2;
	
	@FindBy(xpath="//button[@title='Compare']")
	WebElement CompareBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sony Xperia')]")
	WebElement CompareItem1;
	@FindBy(xpath ="//a[contains(text(),'IPhone')]")
	WebElement CompareItem2;
	
	
	@FindBy(id="empty_cart_button")
	WebElement EmptyCart;
	
	@FindBy (xpath ="//td[@class='product-cart-info']//p[@class='item-msg error']")
	WebElement Errormessage;
	
	@FindBy (xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[2]/p[1]")
	WebElement CartEmptyMessage;
	
	public MobilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String Verify_sort() {
		Select sel=new Select(SortIcon);
		sel.selectByVisibleText("Name");
		return ItemsInPage.getText();
	}
	
	public void Verify_add_item_toCart() {
	    AddtoCart1st.click();
	    QTY.clear();
		QTY.sendKeys("1000");
		UpdateCart.click();
		
	}
	
	public String  verify_error_message() {
		return Errormessage.getText();
	}
	public String Empty_Cart_and_verify_this() {
		EmptyCart.click();
		return CartEmptyMessage.getText();
	}
	
	public void Customer_add_items_toCompare() {
		AddtoCompare1.click();
		Addtocompare2.click();
		CompareBtn.click();
		
	}
	public String[] VerifyCompare_popup_window() {
		Set <String> hand =driver.getWindowHandles();
		Iterator<String> iter=hand.iterator();
		String firstwindowid =iter.next();
		String secondwindowid=iter.next();
		driver.switchTo().window(secondwindowid);
		String item1=CompareItem1.getText();
		String item2 =CompareItem2.getText();
		String items[]= {item1,item2};
		driver.close();
		driver.switchTo().window(firstwindowid);
		return items;
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
