package com.appiumguide.appiumconcepts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.Map;

/**
 * Script Details - Appium Concepts : 🧪 How to Use Appium’s .getSystemBars() Method to Detect “Status & Navigation Bars”
 * 
 * appium-java-client version: latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class GetSystemBarsDemo {
	
	private AndroidDriver driver;
	
								
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel6");		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		
		//To get Android System bars information - Status Bar & Navigation Bar
		System.out.println("To get Android System bars information - Status Bar & Navigation Bar");
		Map <String, Map <String, Object>> systemBars=driver.getSystemBars();
		System.out.println("Navigation Bar & Status Bar: " +systemBars);
		
		Map<String,Object> StatusBar=(Map<String,Object>)systemBars.get("statusBar");
		Map<String,Object> NavBar=(Map<String,Object>)systemBars.get("navigationBar");
		
		//To Print Visibility & Height of Status Bar 
		System.out.println("To Print Visibility & Height of Status Bar");
		System.out.println("Status Bar - Visible or not - "+StatusBar.get("visible"));
		System.out.println("Status bar - Height - "+StatusBar.get("height"));
		
		//To Print Visibility & Height of Navigation Bar 
		System.out.println("To Print Visibility & Height of Navigation Bar");
		System.out.println("Navigation Bar - Visible or not - "+NavBar.get("visible"));
		System.out.println("Navigation bar - Height - "+NavBar.get("height"));
		
		
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


