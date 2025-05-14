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

/**
 * Script Details - Appium Concepts : Part-1 : How to Push/Pull Files during runtime(Complete Details) using methods .pushFile(file) & .pullFile(act)
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class PushPullFiles_Part1 {
	
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
			
		//.pushFile(remotepath, file)
		
		driver.pushFile("/sdcard/download/pushed_sampleImage.png", new File(System.getProperty("user.dir")+"/sampleImage.png"));
		System.out.println("Pushed the sampleImage.png to the test device");
		
		Thread.sleep(8000);
		
		//.pullFile(remotepath)
		
		byte[] pulledfile=driver.pullFile("/sdcard/download/pushed_sampleImage.png");
		Files.write(Paths.get("pulled_sampleImage.png"), pulledfile);
		System.out.println("File pulled & saved as pulled_sampleImage.png");
		
		}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


