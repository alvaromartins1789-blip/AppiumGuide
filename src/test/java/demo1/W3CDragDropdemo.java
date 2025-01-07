package demo1;

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
import org.openqa.selenium.interactions.Sequence;
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

public class W3CDragDropdemo {
	
	private AndroidDriver driver;
	
	WebElement dragelement,dropelement;
		
	@BeforeClass
	public void setup() throws MalformedURLException {
		/*
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		*/
		String sessionId="";
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), sessionId);		
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test
	public void test1() throws InterruptedException {
		
		driver.activateApp("com.wdiodemoapp");
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Drag\")")).click();
		
		
		
		dragelement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)"));
		
		dropelement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(10)"));
		
		int eX=(int)(dropelement.getRect().getX());
		int eY=(int)(dropelement.getRect().getY());
		
		//Perform Drag gesture based on element id, endX & endY co-ordinates
		System.out.println("Perform Drag gesture based on element id, endX & endY co-ordinates");
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",ImmutableMap.of("elementId",((RemoteWebElement) dragelement).getId(),
				"endX",eX,
				"endY",eY));
		
		Thread.sleep(3000);
		dragelement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(7)"));
		
		int sX=(int)(dragelement.getRect().getX());
		int sY=(int)(dragelement.getRect().getY());
		
		dropelement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(8)"));
		
		int eX1=(int)(dropelement.getRect().getX());
		int eY1=(int)(dropelement.getRect().getY());
		
		//Perform Drag gesture based on element id, startX,startY,endX & endY co-ordinates	
		System.out.println("Perform Drag gesture based on element id, startX,startY,endX & endY co-ordinates");
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",ImmutableMap.of(
				"startX",sX,
				"startY",sY,
				"endX",eX1,
				"endY",eY1));
		
		Thread.sleep(3000);
		
		////Perform Drag gesture based on element id,endX,endY co-ordinates and Speed
		
		dragelement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)"));
		
		dropelement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(10)"));
		
		int eX2=(int)(dropelement.getRect().getX());
		int eY2=(int)(dropelement.getRect().getY());
		
		int speedvalue=(int)(100*2.625);
		System.out.println("Perform Drag gesture based on element id,endX,endY co-ordinates and Speed");
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",ImmutableMap.of("elementId",((RemoteWebElement) dragelement).getId(),
				"endX",eX2,
				"endY",eY2,
				"speed",speedvalue));
		
		
		
		
	}
	
	
		
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
		}
		
	}
	

}


