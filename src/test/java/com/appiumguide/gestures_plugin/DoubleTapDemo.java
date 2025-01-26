package com.appiumguide.gestures_plugin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
/**
 * Script Details - How to Perform ‘DoubleTap’ Gesture  Using “Gestures Plugin”
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class DoubleTapDemo{
	
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
		
		
		//Scenario-1: perform doubleTap on CheckBox-1
		System.out.println("Scenario-1: perform doubleTap on CheckBox-1");
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Controls")).click();
		driver.findElement(AppiumBy.accessibilityId("2. Dark Theme")).click();
		element=driver.findElement(AppiumBy.accessibilityId("Checkbox 1"));
		
		driver.executeScript("gesture: doubleTap",ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId()));
		
		Thread.sleep(5000);
		
		//Scenario-2: perform doubleTap on vehiclestatus_number EditBox
		System.out.println("Scenario-2: perform doubleTap on vehiclestatus_number EditBox");
		
		driver.activateApp("com.fastaguser");
		Thread.sleep(5000);
		element=driver.findElement(AppiumBy.id("com.fastaguser:id/txt_vehiclestatus_number"));
		element.sendKeys("12345");
		Thread.sleep(3000);
		
		driver.executeScript("gesture: doubleTap",ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId()));
		

	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


