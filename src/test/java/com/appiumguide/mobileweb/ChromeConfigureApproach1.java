package com.appiumguide.mobileweb;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.net.URL;

/**
 * Script Details - 5 Ways to Configure ‘ChromeDriver’ in Appium --> Approach-1 : By Providing ‘ChromeDriver’ Path in the Desired Capabilities
 * 
 * appium-java-client version: 9.5.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class ChromeConfigureApproach1 {
	
	private AndroidDriver driver;
					
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setCapability("browser","chrome");
		//Provide ‘ChromeDriver’ Path
		cap.setCapability("chromedriverExecutable","C:\\Users\\SWETHARAMESH\\Desktop\\AppiumGuide\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
				
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
		
	@Test
	public void test() throws InterruptedException, IOException {
		
			driver.get("https://appiumguide-by-kodumururamesh.blogspot.com/p/home-page.html");        
		   
	}
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


