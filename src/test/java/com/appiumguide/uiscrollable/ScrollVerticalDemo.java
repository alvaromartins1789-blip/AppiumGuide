package com.appiumguide.uiscrollable;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.*;
import java.time.Duration;

/**
 * Script Details - "Scroll Gestures” -‘UiScrollable’| How to perform "Vertical Scroll" by using 'UiScrollable' Class
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class ScrollVerticalDemo {
	
	private AndroidDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			
	}
	
	@Test
	public void test1() {
		
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"Lists\"))"));
		
		driver.findElement(AppiumBy.accessibilityId("Lists")).click();
		
		driver.findElement(AppiumBy.accessibilityId("01. Array")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"Lists\"))"));
		
		
	}
	
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}



