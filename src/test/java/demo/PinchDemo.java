package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class PinchDemo {
	
	private AndroidDriver driver;
	
	WebElement ele;
	int speedvalue,speedvalue1;
		
		
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
	public void test123() throws InterruptedException {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.documentsui:id/icon_thumb\").instance(3)")).click();
		
		ele=driver.findElement(AppiumBy.id("com.google.android.apps.photos:id/video_player_controller_fragment_container"));
		
		//Perform 'pinchOpenGesture' based on 'elementid,left,top,width,height,percent,speed' arguments
		System.out.println("Perform 'pinchOpenGesture' based on 'elementid,left,top,width,height,percent,speed' arguments");
		
		speedvalue=(int)(100*2.625);
		
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
				"left",80,
				"top",1079,
				"width",1159,
				"height",1890,
				"percent",1.0,
				"speed",speedvalue));
		
		Thread.sleep(2000);
		
		//Perform 'pinchCloseGesture' based on 'elementid,left,top,width,height,percent,speed' arguments
		System.out.println("Perform 'pinchCloseGesture' based on 'elementid,left,top,width,height,percent,speed' arguments");
		
		speedvalue1=(int)(1500*2.625);
		
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
				"left",80,
				"top",1079,
				"width",1159,
				"height",1890,
				"percent",1.0,
				"speed",speedvalue1));
		
		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
				
		//Perform 'pinchOpenGesture' based on 'elementid,percent,speed' arguments
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.documentsui:id/icon_thumb\").instance(1)")).click();
		
		ele=driver.findElement(AppiumBy.id("com.google.android.apps.photos:id/video_player_controller_fragment_container"));
		
		speedvalue=(int)(900*2.625);
		
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
				"percent",0.75,
				"speed",speedvalue));
		
		Thread.sleep(2000);
		
		//Perform 'pinchCloseGesture' based on 'elementid,left,top,width,height,percent,speed' arguments
		System.out.println("Perform 'pinchCloseGesture' based on 'elementid,left,top,width,height,percent,speed' arguments");
		
		speedvalue1=(int)(1000*2.625);
		
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
				"left",80,
				"top",1079,
				"width",1159,
				"height",1890,
				"percent",1.0,
				"speed",speedvalue1));
		
		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		//Perform 'pinchOpenGesture' based on 'elementid,percent' arguments
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.documentsui:id/icon_thumb\").instance(0)")).click();
		
		ele=driver.findElement(AppiumBy.id("com.google.android.apps.photos:id/video_player_controller_fragment_container"));
		
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
				"percent",0.50
				));
		
		Thread.sleep(2000);
		
		//Perform 'pinchCloseGesture' based on 'elementid,left,top,width,height,percent' arguments
		System.out.println("Perform 'pinchCloseGesture' based on 'elementid,left,top,width,height,percent' arguments");
		
	
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
				"left",80,
				"top",1079,
				"width",1159,
				"height",1890,
				"percent",0.50
				));
		
	}	
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");

		}
		
	}
	

}

