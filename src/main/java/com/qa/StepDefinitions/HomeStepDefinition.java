package com.qa.StepDefinitions;

import org.junit.Assert;

import com.qa.Pages.BaseTestClass;
import com.qa.Pages.HomePage;
import com.qa.Pages.MobilePage;
import com.qa.Pages.RegisterPage;
import com.qa.util.Utilclass;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomeStepDefinition extends BaseTestClass{
	public  HomePage homepage;
	public MobilePage mobilepage;
	public RegisterPage regpage;
	@Before 
	public void setup() {
		init();
	}
	
	@Given("^customer is in home page$")
	public void customer_is_in_home_page(){
		homepage=new HomePage();
		String Hometitle=homepage.Verify_home_title();
	   Assert.assertEquals(Utilclass.expectedHomeTitle, Hometitle);
	}
	@Then("^customer click on mobile icon$")
	public void customer_click_on_mobile_icon() {
		String Mobiletitle=homepage.Verify_mobile_icon();
		Assert.assertEquals(Mobiletitle,Utilclass.expectedMobileTitle );
	}
	@Then("^customer sort items by name$")
	public void customer_sort_items_by_name(){
		mobilepage=new MobilePage();
		String  Items=mobilepage.Verify_sort();
	    System.out.println(Items);
	}
	
	@Then("^customer add mobile item to the cart and  change quantitiy to large value and update$")
	public void customer_add_mobile_item_to_the_cart() {
		mobilepage=new MobilePage();
	    mobilepage.Verify_add_item_toCart();
	}
	@Then("^customer verify error message$")
	public void customer_verify_error_message(){
		String errormesage=mobilepage.verify_error_message();
	    System.out.println(errormesage);
	    Assert.assertEquals("* The maximum quantity allowed for purchase is 500.", errormesage);
	}
	
	@Then("^customer empty the cart and verify it is empty$")
	public void customer_empty_the_cart_and_verify_it_is_empty(){
	   String mess= mobilepage.Empty_Cart_and_verify_this();
	   System.out.println(mess);
	   Assert.assertEquals("You have no items in your shopping cart.", mess);
	    
	}
	
	@Then("^customer add  items to compare and click on compare$")
	public void customer_add_items_to_compare_and_click_on_compare(){
		mobilepage=new MobilePage();
	    mobilepage.Customer_add_items_toCompare();
	}
	
	@Then("^customer verify popup window and items in it$")
	public void customer_verify_popup_window_and_items_in_it(){
		String itemsexist []=mobilepage.VerifyCompare_popup_window();
		Assert.assertEquals("SONY XPERIA", itemsexist[0]);
		Assert.assertEquals("IPHONE", itemsexist[1]);
	    
	}

	
	@Then("^verify images and links in mobile page$")
	public void verify_images_and_links_in_mobile_page(){
	    mobilepage.Verify_imgs_and_broken_links();
	}
	
	@Then("^customer click on TV icon$")
	public void customer_click_on_TV_icon(){
		String Tvtitle=homepage.Verify_TV_icon();
		Assert.assertEquals(Utilclass.expectedTvTitle, Tvtitle);
	}
	
	@Then("^customer search on an item$")
	public void customer_search_on_an_item() {
		String ItemsNumber=homepage.Verify_search();
	    System.out.println(ItemsNumber);
	}
	
	@Before ("@Fourth")
	public void Before_fourth_scenario() {
		regpage=new RegisterPage();
		regpage.Verify_register_opening();
	}
	@Then("^customer go to register page from acount icon$")
	public void customer_goto_register_page_from_acount_icon() {
   String regpageTitle =regpage.Verify_RegPage_Title();
   System.out.println(regpageTitle);
   Assert.assertEquals("Create New Customer Account", regpageTitle);
	}
	@Then("^customer fills register page details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and click register$")
	public void customer_fills_register_page_details(String fstName ,String lstname ,String mailadd ,String password ,String passconf ) {
	    regpage.Verify_new_customer_register(fstName, lstname, mailadd, password, passconf);
	}
	
	@After
	public void Teardown() {
		driver.quit();
	}
	

}
