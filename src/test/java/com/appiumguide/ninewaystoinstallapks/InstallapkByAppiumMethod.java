package com.appiumguide.ninewaystoinstallapks;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.IOException;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - 5. “9” Ways to Install APK’s -  By Using ‘.installApp()’ Appium Built-in Method at runtime
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class InstallapkByAppiumMethod {
	
	private AndroidDriver driver;
								
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel9");		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		
		if(driver.isAppInstalled("com.wdiodemoapp")) {
			System.out.println("The wdio app is already installed");
		}else {
			System.out.println("The wdio app is not installed");
			//Install APK file using 'installApp' method
			driver.installApp(System.getProperty("user.dir")+"/APK_Files/android.wdio.native.app.v1.0.8.apk");
			System.out.println("Able to install wdio app successfully");
			
		}
		
		Thread.sleep(5000);
		
		driver.activateApp("com.wdiodemoapp");		
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}

