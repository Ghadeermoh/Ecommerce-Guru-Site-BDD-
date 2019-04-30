package com.qa.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.util.Utilclass;

public class BaseTestClass {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public BaseTestClass() {
		prop =new Properties() ;
		try {
			FileInputStream ip =new FileInputStream(Utilclass.config_path);
			
				prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		String browsername=prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\\\program file\\\\selenium programs\\\\NewChromeDriver\\\\chromedriver_win32\\\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\program file\\selenium programs/geckodriver.exe");  //give location of the driver we already downloaded 
			driver =new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Utilclass.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilclass.Implicit_Wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
