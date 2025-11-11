package com.appiumguide.devicefarm;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - "appium-device-farm”- Run Your First Test Script with “Appium Device Farm”
 * 
 * appium-java-client version: 9.5.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class devicefarm_firstscriptdemo {
	
	private AndroidDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel6");
		
		// Aumentar tempo máximo de inatividade da sessão (em segundos)
		cap.setCapability("newCommandTimeout", 300); // 5 minutos
		
		//Add basepath - /wd/hub to the URL from "http://127.0.0.1:4723" to "http://127.0.0.1:4723/wd/hub"
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void test1() throws InterruptedException {
		
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+
				".scrollIntoView(new UiSelector().text(\"Tabs\"))"));
		
		driver.findElement(AppiumBy.accessibilityId("Tabs")).click();
		
		driver.findElement(AppiumBy.accessibilityId("5. Scrollable")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().setMaxSearchSwipes(10)" +
		         ".scrollIntoView(new UiSelector().text(\"TAB 30\"))"));
						
		Thread.sleep(5000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"TAB 30\")")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().setMaxSearchSwipes(10)" +
		         ".scrollIntoView(new UiSelector().text(\"TAB 1\"))"));
		Thread.sleep(5000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"TAB 1\")")).click();		
	}
	
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
	}
}
