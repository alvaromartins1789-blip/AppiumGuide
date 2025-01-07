
package com.appiumguide.demo1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.AndroidStopScreenRecordingOptions;
import io.appium.java_client.android.geolocation.AndroidGeoLocation;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.screenrecording.ScreenRecordingUploadOptions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Test124 {
	
	private AndroidDriver driver;
	
	boolean scroll;
	
		
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void test() {
		
		
		//driver.activateApp("io.appium.android.apis");
		//driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Dimension size=driver.manage().window().getSize();
		System.out.println(size);
		int left=(int)(size.getWidth()*0.5);
		int top=(int)(size.getHeight()*0.5);
		System.out.println(left);
		System.out.println(top);
		
		int width=(int)(size.getWidth()*0.5);
		//int height=0;
		
		
		
		int speedvalue=(int)(100*2.625);
		
		scroll=(boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left",672,
				"top",0,
				"width",672,
				"height",2100,
				"direction","down",
			    "percent",1.0,
			    "speed",speedvalue
			    
			));
		
		scroll=(boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left",672,
				"top",2100,
				"width",672,
				"height",2100,
				"direction","up",
			    "percent",1.0,
			    "speed",speedvalue
			    
			));
		
		
	}
			
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
		}
		
	}
	

}

