package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Script Details - Appium Concepts : How to Get "appPackage" and "appActivity" during runtime(programmatically)
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class PackActTest1 {
	
private AndroidDriver driver;
	
	@BeforeTest
	public void steup() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixal7a");
		cap.setAppPackage("com.google.android.deskclock");
		cap.setAppActivity("com.android.deskclock.DeskClock");
				
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
	}
	@Test
	public void PackActSample1() {
		
		String pack=driver.getCurrentPackage();
		System.out.println("Current apppackage details - "+pack);
		String act=driver.currentActivity();
		System.out.println("Current appActivity details - "+act);
	}

}
