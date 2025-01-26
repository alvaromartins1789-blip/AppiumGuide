package com.appiumguide.gesturesplugin;

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
 * Script Details - How to Perform ‘Swipe’ Gesture Using “Gestures Plugin” - Direction – Up/Down
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class SwipeGestureDemo {
	
	private AndroidDriver driver;
	WebElement element;
					
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		//Scenario-1 - perform swipe on apis demo app
		System.out.println("Scenario-1");
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/content\")"));
		
		//Scenario-1 Perform swipe direction - up
		System.out.println("Scenario-1 Perform swipe direction - up");
		
		driver.executeScript("gesture: swipe",ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
				"percentage",50,
				"direction","up"));
		
		Thread.sleep(3000);
		
		//Scenario-1 Perform swipe direction - down
				System.out.println("Scenario-1 Perform swipe direction - down");
				
		driver.executeScript("gesture: swipe", ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
				"percentage",100,
				"direction","down"));
		
		Thread.sleep(3000);
		
		//Scenario-2 - perform swipe on burger king app
		
		System.out.println("Scenario-2");
		
		driver.activateApp("in.burgerking.android");
		Thread.sleep(10000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"BK Recommended\").instance(0)")).click();
		Thread.sleep(3000);
		
		element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(69)"));
		
		//Scenario-2 Perform swipe direction - up
		System.out.println("Scenario-2 Perform swipe direction - up");
		
		driver.executeScript("gesture: swipe",ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
				"percentage",75,
				"direction","up"));
		
		Thread.sleep(3000);
		
		//Scenario-2 Perform swipe direction - down
				System.out.println("Scenario-2 Perform swipe direction - down");
				
		driver.executeScript("gesture: swipe", ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
				"percentage",40,
				"direction","down"));
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


