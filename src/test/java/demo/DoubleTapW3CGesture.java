package demo;

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

public class DoubleTapW3CGesture {
	
	private AndroidDriver driver;
	WebElement element;
				
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.activateApp("com.fastaguser");
		element=driver.findElement(AppiumBy.id("com.fastaguser:id/txt_vehiclestatus_number"));
		element.sendKeys("12345");
		
		//double tap/click gesture using elementId
		System.out.println("double tap/click gesture using elementId");
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(6)")).click();
		
		element=driver.findElement(AppiumBy.id("com.fastaguser:id/vehicle_id_txt"));
		element.sendKeys("5555");
		//double tap/click gesture using x & y co-ordinates
		System.out.println("double tap/click gesture using elementId and x & y co-ordinates");
		
		int x=((element.getRect().getX())+(element.getRect().getWidth())/2);
		int y=((element.getRect().getY())+(element.getRect().getHeight())/2);
		
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",ImmutableMap.of("x",x,"y",y));
		
		driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(8)")).click();
		
		//double tap/click gesture using map i.e elementId and x & y co-ordinates
		
		System.out.println("double tap/click gesture using map i.e elementId and x & y co-ordinates");
		
		element=driver.findElement(AppiumBy.id("com.fastaguser:id/vehicle_id_txt"));
		element.sendKeys("1111");
		
		int x1=((element.getRect().getX())+(element.getRect().getWidth())/2);
		int y1=((element.getRect().getY())+(element.getRect().getHeight())/2);
		
				
		HashMap<String,Object> map=new HashMap<>();
		map.put("elementId",element);
		map.put("x",x1);
		map.put("y",y1);
		
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",map);
		
		Thread.sleep(5000);
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
		}
		
	}
	

}

