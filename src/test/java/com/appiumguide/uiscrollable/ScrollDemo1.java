package com.appiumguide.uiscrollable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - "Scroll Gestures” -‘UiScrollable’ | How to perform "Simple Scroll" by using 'UiScrollable' Class
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class ScrollDemo1 {
	
	private AndroidDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			
	}
	
	@Test
	public void ScrollTest1() throws InterruptedException {
		
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+
				".scrollIntoView(new UiSelector().text(\"Tabs\"))"));
		
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.accessibilityId("Tabs")).click();
		
		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(3000);
		
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+
				".scrollIntoView(new UiSelector().textContains(\"Animati\"))"));
		
		Thread.sleep(3000);
		
		
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		
		
		
		
	}
	
			
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}