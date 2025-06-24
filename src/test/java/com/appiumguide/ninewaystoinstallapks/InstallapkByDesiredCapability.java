package com.appiumguide.ninewaystoinstallapks;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - 9. “9” Ways to Install APK’s -  Install By Using “Appium-Desired Capabilities”
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class InstallapkByDesiredCapability {
	
	private AndroidDriver driver;
	File screenshot;
								
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel6");
		
		//Install apk by using desired capability
		String basepath=System.getProperty("user.dir")+"/APK_Files/";
		String apkpath=basepath+"ApiDemos.apk";
		cap.setApp(apkpath);
		cap.autoGrantPermissions();
		cap.noReset();
					
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


