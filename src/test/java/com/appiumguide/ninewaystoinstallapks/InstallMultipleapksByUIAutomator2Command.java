package com.appiumguide.ninewaystoinstallapks;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * Script Details - 7. “9” Ways to Install APK’s -  By Using ‘mobile: installMultipleApks’ - UIAutomator2 driver Command at runtime
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class InstallMultipleapksByUIAutomator2Command {
	
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
	public void test() throws InterruptedException, IOException {
		
		String basepath=System.getProperty("user.dir") + "/APK_Files/";
		
	List<String> apkPaths=Arrays.asList(
			basepath+"android.wdio.native.app.v1.0.8.apk",
			basepath+"ApiDemos.apk",
			basepath+"selendroid-test-app.apk"
				);
		
		
		//Install multiple APKs by using UIAutomator2 driver command 'mobile: installMultipleApks'
		System.out.println("Install multiple APKs by using UIAutomator2 driver command 'mobile: installMultipleApks'");
		
		// Approach - 1 (apks-with same package name & (.aab)Android App Bundle)
		driver.executeScript("mobile: installMultipleApks", ImmutableMap.of("apks",apkPaths));
		
		
		//Approach - 2 (apks-with different package name & (.aab)Android App Bundle)
		for(String apk:apkPaths) {
			driver.installApp(apk);
			Thread.sleep(3000);
		}
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


