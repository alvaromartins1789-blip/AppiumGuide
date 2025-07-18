package com.appiumguide.capabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Script Details . ‘Appium’ – “Capabilities”  -  Complete Details on “appium:options”
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class AppiumOptions_Demo {
	
	private AndroidDriver driver;
	File screenshot;
								
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		//Install apk by using desired capability
		String basepath=System.getProperty("user.dir")+"/APK_Files/";
		String apkpath=basepath+"ApiDemos.apk";
		
		
		//appium:options container
		Map<String,Object> appiumOptions=new HashMap<>();
		
		appiumOptions.put("platformVersion", "13");
		appiumOptions.put("automationName", "uiautomator2");
		appiumOptions.put("deviceName", "Pixel6");
		appiumOptions.put("app", apkpath);
		appiumOptions.put("noReset", true);
		appiumOptions.put("autoGrantPermissions", true);
		appiumOptions.put("newCommandTimeout", 120);
		
		UiAutomator2Options cap=new UiAutomator2Options();
		//PlatformName at root-level
		cap.setPlatformName("android");
		
		cap.setCapability("appium:options", appiumOptions);	
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		
		
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


