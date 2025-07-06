package com.appiumguide.advanceappiumconcepts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.PowerACState;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.IOException;
import java.net.*;
import java.time.Duration;

public class PlugandunplugdevicechargerDemo {
	
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
		
		
		driver.activateApp("io.appium.android.apis");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+
				".scrollIntoView(new UiSelector().text(\"Tabs\"))"));
		driver.findElement(AppiumBy.accessibilityId("Tabs")).click();
		driver.findElement(AppiumBy.accessibilityId("5. Scrollable")).click();
		driver.findElement(AppiumBy.androidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().setMaxSearchSwipes(10)" +
		         ".scrollIntoView(new UiSelector().text(\"TAB 30\"))"));
		Thread.sleep(5000);
		
		//Plugging the Device Charger
		System.out.println("Plugging the Device Charger");
		driver.setPowerAC(PowerACState.ON);
		
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"TAB 30\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().setMaxSearchSwipes(10)" +
		         ".scrollIntoView(new UiSelector().text(\"TAB 1\"))"));
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"TAB 1\")")).click();
		
		
		//Unplugging the device charger
		System.out.println("Unplugging the device charger");
		driver.setPowerAC(PowerACState.OFF);
		
		Thread.sleep(5000);
		
		//Plugging the Device Charger
		System.out.println("Plugging the Device Charger");
		driver.setPowerAC(PowerACState.ON);
		
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


