package com.qa.StepDefinitions;

import org.junit.Assert;

import com.qa.Pages.BaseTestClass;
import com.qa.Pages.HomePage;
import com.qa.util.Utilclass;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomeStepDefinition extends BaseTestClass{
	public  HomePage homepage;
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
	
	@After
	public void Teardown() {
		driver.quit();
	}
	

}
