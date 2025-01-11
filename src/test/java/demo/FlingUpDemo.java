package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class FlingUpDemo {
	
	private AndroidDriver driver;
	WebElement element;
	int speedvalue;
			
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
		
		//Perform fling gesture to open notification.
		
		System.out.println("Perform fling gesture to open notification.");
		
		element=driver.findElement(AppiumBy.id("com.google.android.apps.nexuslauncher:id/workspace"));
		
		speedvalue=(int)(7500*2.625);
		
		((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
				"direction","up",
				"speed",speedvalue
				));
		
		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		Thread.sleep(3000);
		
		driver.activateApp("in.burgerking.android");
		
		Thread.sleep(3000);
		
		//Perform fling gesture to refresh the app.
		System.out.println("Perform fling gesture to refresh the app.");
		
		element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(0)"));
		
		
		
		((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
				"direction","up"				
				));				
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}


