package com.appiumguide.appium3;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
/**
 * Script Details - How to Run arbitrary ADB commands via Appium {.executeScript("mobile: shell", <arg>)};
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

/*
Scenario's covered:
-----------------------------------------
//adb shell dumpsys window displays|grep -e 'mCurrentFocus'

*/

public class adb_shellAppium3Demo {
	
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
	public void test() throws InterruptedException {
		
		
		
		//Scenario-1
		System.out.println("Scenario-2");
		//Running the '//adb shell dumpsys window displays|grep -e 'mCurrentFocus' to fetch appPackege & appActivity details
		
		System.out.println("Running the '//adb shell dumpsys window displays|grep -e 'mCurrentFocus' to fetch appPackege & appActivity details");
		Object Output1=driver.executeScript("mobile: shell",ImmutableMap.of(
				"command","dumpsys window displays|grep -e",
				"args","'mCurrentFocus'"));
		System.out.println("Output1 value- "+Output1.toString());
		
		//adb shell dumpsys window displays|grep -e 'mCurrentFocus'
		
		String Output2=(String) driver.executeScript("mobile: shell",ImmutableMap.of(
				"command","dumpsys window displays|grep -e",
				"args","'mCurrentFocus'"));
		System.out.println("Output1 value- "+Output2);
		
		System.out.println(driver.getCapabilities().getCapability("appium:viewportRect"));
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


