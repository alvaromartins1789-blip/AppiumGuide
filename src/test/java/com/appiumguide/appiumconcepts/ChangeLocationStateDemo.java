package com.appiumguide.appiumconcepts;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - Appium Concepts : Enabling & Disabling “LocationServices” via Appium(Built-In Method) at Runtime
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class ChangeLocationStateDemo {
	
	private AndroidDriver driver;
					
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("device-13");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
		
	@Test
	public void test() throws InterruptedException, IOException {
		
		//Enable or Disable the Location services (GPS-on/off)
		
		//Disable the Location services (GPS-OFF),if it is already enabled
		driver.toggleLocationServices();
		System.out.println("Location Services is disbaled i.e. GPS is OFF");
		Thread.sleep(5000);
		
		
		//Enable the Location services (GPS-ON), if it is disabled
		driver.toggleLocationServices();
		System.out.println("Loaction Services is enabled i.e. GPS is ON");
		
		}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}



