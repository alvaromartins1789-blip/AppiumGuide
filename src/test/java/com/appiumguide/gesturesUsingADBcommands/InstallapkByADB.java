package com.appiumguide.gesturesUsingADBcommands;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Script Details - 4. “9” Ways to Install APK’s -  Install by Using/Running ‘ADB Command’ via ‘Appium’ (Client)
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class InstallapkByADB {
	
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
		
		//Step-1: Upload a apk file to the device
		
		driver.pushFile("/data/local/tmp/selendroid-test-app.apk",new File(System.getProperty("user.dir")+"/APK_Files/selendroid-test-app.apk"));
		
		Thread.sleep(5000);
		
		System.out.println("Uploaded a apk file to the device");
		
		//Step2: Install the apk file in our simulator
		
		driver.executeScript("mobile: shell", ImmutableMap.of(
				"command","pm",
				"args",Arrays.asList("install","/data/local/tmp/selendroid-test-app.apk")));
		
		System.out.println("Installed apk file successfully");

		}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


