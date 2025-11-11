package com.appiumguide.devicefarm;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
import java.util.Arrays;

/**
 * Script Details - "appium-device-farm”- Step-by-Step Details: How to Create & Configure “Tags” in  “Appium Device Farm”
 * 
 * appium-java-client version: 9.5.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class devicefarm_DeviceTagsDemo {
	
	private AndroidDriver driver;
	
	WebElement dragelement,dropelement;
		
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		
		// Aumentar tempo máximo de inatividade da sessão (em segundos)
		cap.setCapability("newCommandTimeout", 300); // 5 minutos
					
		// Specify the Tags as Capabilities - for Test-1
		
		//cap.setCapability("df:tags", Arrays.asList("TeamB","WDIOApp","AndroidEmulator")); //Pass the values as array
		
		
		// Specify the Tags as Capabilities - for Test-2
		
		cap.setCapability("df:tags", Arrays.asList("TeamA","ApiDemosApp","RealDevice")); //Pass the values as array
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	
	@Test
	public void test1() throws InterruptedException {
		
		
		// Code for Test- 1 (cap.setCapability("df:tags", Arrays.asList("TeamB","WDIOApp","AndroidEmulator"));)
		
		/*
		driver.activateApp("com.wdiodemoapp");
		
		Thread.sleep(5000);
		
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
		
		Thread.sleep(3000);
		*/
		
		
		//code for Test-2 - (cap.setCapability("df:tags", Arrays.asList("TeamA","ApiDemosApp","RealDevice"));
		
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
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");

		}
		
	}
	

}


