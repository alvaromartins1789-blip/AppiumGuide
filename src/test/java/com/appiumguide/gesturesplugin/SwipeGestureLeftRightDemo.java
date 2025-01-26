package com.appiumguide.gesturesplugin;

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
import java.util.Map;
/**
 * Script Details - How to Perform ‘Swipe’ Gesture Using “Gestures Plugin” - Direction – Left/Right
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */
public class SwipeGestureLeftRightDemo {
	
	private AndroidDriver driver;
					
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
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+
				".scrollIntoView(new UiSelector().text(\"Tabs\"))"));
		
		driver.findElement(AppiumBy.accessibilityId("Tabs")).click();
		
		driver.findElement(AppiumBy.accessibilityId("5. Scrollable")).click();
		
		WebElement element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/tabs\")"));
		
		//Perform swipe to direction-left
		System.out.println("Perform swipe to direction-left");
		
		driver.executeScript("gesture: swipe",ImmutableMap.of(
				"elementId",((RemoteWebElement) element).getId(),
				"percentage",75,
				"direction","left"));
		
		Thread.sleep(3000);
		
		//Perform swipe to direction-right
		System.out.println("Perform swipe to direction-right");
				
		driver.executeScript("gesture: swipe",ImmutableMap.of(
				"elementId",((RemoteWebElement) element).getId(),
				"percentage",50,
				"direction","right"));
		
		
		
		

		
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


