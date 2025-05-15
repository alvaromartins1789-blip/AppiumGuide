package com.appiumguide.gesturesUsingADBcommands;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.Arrays;

/**
 * Script Details - Perform ‘Tap’ Gesture on a element & mobile screen By Using/Running “adb Commands”
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class TapDemoUsingADB {
	
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
		
		//Open the Apidemos app
		System.out.println("Open the Apidemos app");
		driver.activateApp("io.appium.android.apis");
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Controls")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("1. Light Theme")).click();
		Thread.sleep(2000);
		
		//Calculate the x & y co-ordinates values of Checkbox 1 element
		System.out.println("Calculate the x & y co-oradinates values");
		WebElement element=driver.findElement(AppiumBy.accessibilityId("Checkbox 1"));
				int x=element.getRect().getX();
				int y=element.getRect().getY();
				int width=element.getRect().getWidth();
				int height=element.getRect().getHeight();
				int x1= (int)x+width/2;
				int y1= (int)y+height/2;
		
		//Perform Tap Gestures Using ADB Commands to Tap on the Checkbox-1
		System.out.println("//Perform Tap Gestures Using ADB Commands to Tap on the Checkbox-1");
		driver.executeScript("mobile: shell", ImmutableMap.of(
				"command","input",
				"args",Arrays.asList("tap",x1,y1)));
		
		Thread.sleep(5000);
		
		//Perform Tap Gestures Using ADB Commands to Tap on the Checkbox-1 once again
		System.out.println("//Perform Tap Gestures Using ADB Commands to Tap on the Checkbox-1 once again");
		driver.executeScript("mobile: shell", ImmutableMap.of(
				"command","input",
				"args",Arrays.asList("tap",x1,y1)));
		
		
		}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}



