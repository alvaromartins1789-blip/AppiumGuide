package com.appiumguide.appiuminspector;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/*
List of Scenarios to be perform in the video:
-----------------------------------------
Step-1:

1. Activate App(Launch the app) 
2. Fetch “appPackage” details of the Current app.
3. Fetch “appActivity” details of the Current app.
4. Fetch Current Screen Orientation
5. Change Screen Orientation
6. Close the App

*/

public class AppiumcommandsUsingRecorderTab {
	
	private AndroidDriver driver;
	ScreenOrientation orientation;
						
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel7Pro11");		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		//Activate App(Launch the app)
		System.out.println("Activate App(Launch the app)");
		driver.activateApp("io.appium.android.apis");
		Thread.sleep(3000);
		
		//Fetch “appPackage” details of the Current app.
		System.out.println("Fetch “appPackage” details of the Current app.");
		Object packageName = driver.executeScript("mobile: getCurrentPackage");
		System.out.println("AppPackage - "+packageName.toString());
		Thread.sleep(3000);
		
		//Fetch “appActivity” details of the Current app.
		System.out.println("Fetch “appActivity” details of the Current app.");
		Object activityName = driver.executeScript("mobile: getCurrentActivity");
		System.out.println("AppActivity - "+activityName.toString());
		Thread.sleep(3000);
		
		//Fetch Current Screen Orientation
		System.out.println("Fetch Current Screen Orientation");
		orientation = driver.getOrientation();
		Thread.sleep(3000);
		System.out.println("Present orientation - "+orientation);
		
		//Change Screen Orientation
		System.out.println("Change Screen Orientation");
		driver.rotate(ScreenOrientation.LANDSCAPE);
		orientation = driver.getOrientation();
		Thread.sleep(3000);
		System.out.println("Present orientation - "+orientation);
		
		//Change Screen Orientation
		System.out.println("Change Screen Orientation");
		driver.rotate(ScreenOrientation.PORTRAIT);
		orientation = driver.getOrientation();
		Thread.sleep(3000);
		System.out.println("Present orientation - "+orientation);
		
		//Close the App
		System.out.println("Close the App");
		driver.terminateApp("io.appium.android.apis");

		
		

	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}

