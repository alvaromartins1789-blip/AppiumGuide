package demo;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - Appium commands for “Power Management” - (UiAutomator2 driver(emulators) using commands - "mobile: powerAc" & "mobile: powerCapacity"
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

/*
Scenario's will be covered in the video:
-----------------------------------------
1. Change the power capacity (AC Power State)
2. Power-ON the emulator.
3. Power-OFF the emulator.
*/

public class PowerManagementDemo {
	
	private AndroidDriver driver;
					
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		
		//Scenario-1: Change the power capacity (AC Power State)
		System.out.println("Scenario-1: Change the power capacity (AC Power State)");
		
		driver.executeScript("mobile: powerCapacity",ImmutableMap.of(
				"percent","77"));
				
				
		//Scenario-2: Power-ON the emulator.
		System.out.println("Scenario-2: Power-ON the emulator.");
		
		driver.executeScript("mobile: powerAc",ImmutableMap.of(
				"state","on"));
		
		//Scenario-3: Power-OFF the emulator.
		
		System.out.println("Power-OFF the emulator.");
		
		driver.executeScript("mobile: powerAc",ImmutableMap.of(
				"state","off"));
		
		
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}

