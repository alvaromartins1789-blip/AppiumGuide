package demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
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
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LongPressDemo {
	
	private AndroidDriver driver;
	WebElement ele;
	
		
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(priority=1)
	public void Test1() throws InterruptedException {
		
		//Performing longpress on fasttag app on the editbox
		driver.activateApp("com.fastaguser");
		Thread.sleep(5000);
		ele=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fastaguser:id/txt_vehiclestatus_number\")"));
		ele.sendKeys("12345");
		
		int x=ele.getRect().getX();
		int y=ele.getRect().getY();
		int width=ele.getRect().getWidth();
		int height=ele.getRect().getHeight();
		
		
		Point centerofelement=new Point((int)(x+width/2),(int)(y+height/2));
		
		
		
		PointerInput indexfinger=new PointerInput(Kind.TOUCH,"indexfinger");
		Sequence seq=new Sequence(indexfinger, 0);
		
		System.out.println("Performing longpress on fasttag app on the editbox");
		
		seq.addAction(indexfinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerofelement));
		seq.addAction(indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger,Duration.ofSeconds(5)));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(seq));		
		Thread.sleep(5000);
		driver.terminateApp("com.fastaguser");
	}
	
	
	@Test(priority=2)
	public void Test2() throws InterruptedException {
		//Performing longpress on fasttag app on the peopleNames list
		Thread.sleep(5000);
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		ele=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));
		
		
		int x=ele.getRect().getX();
		int y=ele.getRect().getY();
		int width=ele.getRect().getWidth();
		int height=ele.getRect().getHeight();
		
		
		Point centerofelement=new Point((int)(x+width/2),(int)(y+height/2));	
		
		System.out.println("Performing longpress on fasttag app on the peopleNames list");	
		PointerInput indexfinger=new PointerInput(Kind.TOUCH,"indexfinger");
		Sequence seq=new Sequence(indexfinger, 0);
		
		seq.addAction(indexfinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerofelement));
		seq.addAction(indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger,Duration.ofSeconds(5)));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(seq));	
		Thread.sleep(5000);
		driver.terminateApp("io.appium.android.apis");
	}
	
	@Test(priority=3)
	public void Test3() throws InterruptedException {
			
		
		//Performing longpress on youtube icon"
		Thread.sleep(5000);	
		PointerInput indexfinger=new PointerInput(Kind.TOUCH,"indexfinger");
		Sequence seq=new Sequence(indexfinger, 0);
		System.out.println("Performing longpress on youtube icon");	
		seq.addAction(indexfinger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 1144, 1935));
		seq.addAction(indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger,Duration.ofSeconds(5)));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(seq));		
	}
	
	
	
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
		}
		
	}
	

}
