package com.appiumguide.appiumconcepts;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;

/**
 * Script Details - Appium Concepts : Part-2 : How to Push/Pull Files during runtime(Complete Details) using methods .pushFile(base64Data) & .pullFile(act)
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class PushPullFiles_Part2 {
	
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
	
		//Push the file from local machine to test device
		
		File file=new File(System.getProperty("user.dir")+"/3fingers.png");
		byte[] fileContent=Files.readAllBytes(file.toPath());
		byte[] base64String=Base64.getEncoder().encode(fileContent);
		
		
		driver.pushFile("/sdcard/download/pushed_3fingers.png", base64String);
		System.out.println("Pushed the file from loacl machine to test device");
		
		Thread.sleep(5000);
		
		//Pull the file from test device to our local machine
		
		byte[] pulledbase64=driver.pullFile("/sdcard/download/pushed_3fingers.png");
		Files.write(Paths.get("pulled_3fingers.png"), pulledbase64);
		System.out.println("File pulled from the test device & saved as 'pulled_3fingers.png'");

	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


