package demo;


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

public class FlingAreaDemo {
	
	private AndroidDriver driver;
	int centerx,centery,widthx,heighty;
	
			
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
		
		driver.activateApp("net.organicbazar");
		Thread.sleep(5000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)")).click();
		Thread.sleep(3000);
		//perform fling gesture direction to right
		System.out.println("perform fling gesture direction to right");
		
		WebElement element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
		
		centerx=(int)(element.getRect().getWidth()*0.5);
		centery=(int)(element.getRect().getHeight()*0.5);
		
		widthx=(int)(element.getRect().getWidth()*0.2);
		heighty=(int)(element.getRect().getHeight()*0.5);
		
		((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
				"left",centerx,
				"top",centery,
				"width",widthx,
				"height",heighty,
				"direction","right"));
		
		Thread.sleep(3000);
		
		centerx=(int)(element.getRect().getWidth()*0.5);
		centery=(int)(element.getRect().getHeight()*0.5);
		
		widthx=(int)(element.getRect().getWidth()*0.8);
		heighty=(int)(element.getRect().getHeight()*0.5);
		
		//perform fling gesture direction to left
		System.out.println("perform fling gesture direction to left");
		
		int speedvalue=(int)(500*2.625);
		
		((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
				"left",centerx,
				"top",centery,
				"width",widthx,
				"height",heighty,
				"direction","left",
				"speed",speedvalue));		
				
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
		}
		
	}
	

}


