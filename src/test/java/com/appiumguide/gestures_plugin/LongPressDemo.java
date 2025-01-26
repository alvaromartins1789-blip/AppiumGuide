package com.appiumguide.gestures_plugin;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - How to Perform ‘LongPress’ Gesture  Using “Gestures Plugin”
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class LongPressDemo {
	
	private AndroidDriver driver;
	WebElement element;			
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel7Pro11");		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//Scenario-1 Perform Longpress on the element - peoplenames
		System.out.println("Scenario-1 Perform Longpress on the element - peoplenames");
		
		element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));
		
		driver.executeScript("gesture: longPress",ImmutableMap.of(
				"elementId",((RemoteWebElement) element).getId(),
				"pressure",0.6,
				"duration",1000));
		
		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//Scenario-2 Perform Longpress on the element - Dog Names
		System.out.println("Scenario-1 Perform Longpress on the element - Dog Names");
		
		element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Dog Names\")"));
		
		driver.executeScript("gesture: longPress",ImmutableMap.of(
				"elementId",((RemoteWebElement) element).getId(),
				"pressure",0.6,
				"duration",1000));
			

	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


