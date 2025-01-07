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

public class TapDemoW3CMobileGesture {
	
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
	@Test
	public void sampledemo() throws InterruptedException {
		
				
		driver.activateApp("io.appium.android.apis");		
		ele=driver.findElement(AppiumBy.accessibilityId("Views"));	
		
		//Tap based on elementId
		Thread.sleep(3000);
				
		System.out.println("Tap 'Views' based on elementId");
		
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",ImmutableMap.of("elementId",((RemoteWebElement) ele).getId()));

		ele=driver.findElement(AppiumBy.accessibilityId("Controls"));
		
		int x=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y=((ele.getRect().getY())+(ele.getRect().getHeight())/2);
		
		//Tap based on x & Y co-ordinates
		
		Thread.sleep(3000);
		
		System.out.println("Tap 'Controls' based on X & Y co-ordinates");
		
		((JavascriptExecutor) driver).executeScript("mobile:clickGesture",ImmutableMap.of("x",x,"y",y));
		
		ele=driver.findElement(AppiumBy.accessibilityId("2. Dark Theme"));		
		int x1=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y1=((ele.getRect().getY())+(ele.getRect().getHeight())/2);		

		Thread.sleep(3000);
		//Tap based on elementId,x & Y co-ordinates
		System.out.println("Tap '2. Dark Theme' based on elementId,x & Y co-ordinates");
		
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",ImmutableMap.of("elementId",((RemoteWebElement) ele).getId()),
				"x",x1,
				"y",y1);		
		ele=driver.findElement(AppiumBy.accessibilityId("Checkbox 2"));		
		int x2=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y2=((ele.getRect().getY())+(ele.getRect().getHeight())/2);		
		//Tap based on Map
				System.out.println("Tap 'Checkbox 2' based on Map");	
		HashMap<String,Object> map=new HashMap<>();
		map.put("elementId",((RemoteWebElement)ele).getId());
		map.put("x","x2");
		map.put("y","y2");
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",map);		
	}
	
			
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
		}
		
	}
	

}


