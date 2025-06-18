package com.appiumguide.appiumconcepts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.PowerACState;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;

/**
 * Script Details - Appium Concepts : 🔥Automate Battery and Power Testing By Using Appium built-in methods setPowerCapacity +  setPowerAC
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

@SuppressWarnings("unused")
public class PowerManagementDemo  {
	
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
		
		//To Change the Battery charge levels
		System.out.println("Change the Battery charge level to - 75%");
		driver.setPowerCapacity(75);
		Thread.sleep(5000);
		System.out.println("Change the Battery charge level to 10%");
		driver.setPowerCapacity(10);
		Thread.sleep(5000);
		System.out.println("Change the Battery charge level to 100%");
		driver.setPowerCapacity(100);
		Thread.sleep(5000);
		
		//Simulate the plugging/unplugging the device charger
		System.out.println("Simulate the plugging/unplugging the device charger");
		
		
		//Unplug the device charger
		System.out.println("Unplug the device charger -  'off' to simulate unplugged");
		driver.setPowerAC(PowerACState.OFF);
		Thread.sleep(8000);
		//plug the device charger
		System.out.println("plug the device charger - 'on' to simulate charging");
		driver.setPowerAC(PowerACState.ON);
		
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


