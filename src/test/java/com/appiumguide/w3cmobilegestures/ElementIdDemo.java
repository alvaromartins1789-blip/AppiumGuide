package com.appiumguide.w3cmobilegestures;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - Complete Details on “elementId” –((RemoteWebElement) element).getId())
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class ElementIdDemo {
	
	private AndroidDriver driver;
	 String element_id;		
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
		//To launch Api Demos app
		driver.activateApp("io.appium.android.apis");
		
		 WebElement element=driver.findElement(AppiumBy.accessibilityId("Views"));
		//Tap on views 
		 
		 //Scenario-1 to fetch the elementId Value
		 System.out.println("Scenario-1 to fetch the elementId Value");
		 element_id=((RemoteWebElement)element).getId();
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture",ImmutableMap.of(
				"elementId",element_id));
		
		System.out.println("elementId value -" +element_id); //print elementId hexadecimal value
		
		
		//Scenario-2 Check whether "elementId" is based on session or not?
		 System.out.println("Scenario-2 Check whether elementId is based on session or not?");
		 
		 element_id=((RemoteWebElement)element).getId();
		 System.out.println("Generated element id "+element_id); //print elementId hexadecimal value
		 
			((JavascriptExecutor)driver).executeScript("mobile: clickGesture",ImmutableMap.of(
					"elementId","00000000-0000-0094-ffff-ffff00000011"));
																
			System.out.println("elementId value provided - 00000000-0000-0094-ffff-ffff00000011");
		 
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


