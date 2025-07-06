
package com.appiumguide.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - "Appium Capabilities” - Complete Details on “Appium (W3C-Capabilities)”
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class W3C_CapabilitiesDemo {
	
	private AndroidDriver driver;
	
								
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		/*
		//DesiredCapabilities ((Non-W3C / JSONWP) 
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("automationName", "UiAutomator2");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		*/
			
		//Android (W3C-compliant)
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("emulator-5554");
		options.setPlatformVersion("13.0");
		options.setAutomationName("UiAutomator2");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		/*		
		//iOS (W3C-compliant)
		
		XCUITestOptions options = new XCUITestOptions();
		options.setPlatformName("iOS");
		options.setDeviceName("iPhone 14");
		options.setPlatformVersion("16.4");
		options.setAutomationName("XCUITest");
		
		IOSDriver driver = new IOSDriver(new URL("http://localhost:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		*/		
		
	}
	
	@Test
	public void test() {
		
		//Fetch Current Session ID Details
		System.out.println("Current Session ID Details -" +driver.getSessionId());
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}

