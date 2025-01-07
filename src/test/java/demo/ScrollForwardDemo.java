package demo;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.*;
import java.time.Duration;

public class ScrollForwardDemo {
	
	private AndroidDriver driver;
	
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
	public void test1() {
		
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollForward(100)"));
		
		
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
		}
		
	}
	

}



