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
 * Script Details - Appium Concepts : Difference between methods .activateApp Vs .terminateApp Vs .removeApp
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class DiffBTWMethods {
	
	private AndroidDriver driver;
					
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
		
	@Test
	public void test() throws InterruptedException, IOException {
					
		//Case-1: Start an wdiodemo app
		driver.activateApp("com.wdiodemoapp");
		System.out.println("Started wdiodemo app successfully");
		
		Thread.sleep(5000);
				
		//Case-2: Open the wdiodemo app from background
		driver.activateApp("com.wdiodemoapp");
		System.out.println("Opened the wdiodemo app successfully");
		
		
		//Close the wdiodemo app
		driver.terminateApp("com.wdiodemoapp");
		System.out.println("Close the wdiodemo app");
		
		Thread.sleep(10000);
		
		//Uninstall the wdiodemo app
		driver.removeApp("com.wdiodemoapp");
		System.out.println("Uninstall the wdiodemo app");
				
		}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}



