package com.appiumguide.appiuminspector;

import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

public class GesturesUsingRecorderTab {
	
	private AndroidDriver driver;
	PointerInput finger = null;
					
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
		
		driver.activateApp("io.appium.android.apis");
		
		Thread.sleep(3000);
		
		//Code to Perform Tab Gesture
		System.out.println("Code to Perform Tab Gesture");
		

			finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Point tapPoint = new Point(191, 2144);
			Sequence tap = new Sequence(finger, 1);
			tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
			    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
			tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			tap.addAction(new Pause(finger, Duration.ofMillis(50)));
			tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			driver.perform(Arrays.asList(tap));
			
			Thread.sleep(3000);
			
		//Code to Perform swipe Gesture
			System.out.println("Code to Perform swipe Gesture");	

			finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Point start = new Point(619, 2674);
			Point end = new Point (631, 506);
			Sequence swipe = new Sequence(finger, 1);
			swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
			    PointerInput.Origin.viewport(), start.getX(), start.getY()));
			swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
			    PointerInput.Origin.viewport(), end.getX(), end.getY()));
			swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			driver.perform(Arrays.asList(swipe));

	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}

