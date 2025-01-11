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
import java.util.HashMap;

/**
 * Script Details - Appium Gestures - ‘DoubleTap/DoubleClick’ Using W3C mobile Gestures
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class DoubleTapW3CGesture {
	
	private AndroidDriver driver;
	WebElement element;
				
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
	public void test() throws InterruptedException {
		driver.activateApp("com.fastaguser");
		element=driver.findElement(AppiumBy.id("com.fastaguser:id/txt_vehiclestatus_number"));
		element.sendKeys("12345");
		
		//double tap/click gesture using elementId
		System.out.println("double tap/click gesture using elementId");
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(6)")).click();
		
		element=driver.findElement(AppiumBy.id("com.fastaguser:id/vehicle_id_txt"));
		element.sendKeys("5555");
		//double tap/click gesture using x & y co-ordinates
		System.out.println("double tap/click gesture using elementId and x & y co-ordinates");
		
		int x=((element.getRect().getX())+(element.getRect().getWidth())/2);
		int y=((element.getRect().getY())+(element.getRect().getHeight())/2);
		
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",ImmutableMap.of("x",x,"y",y));
		
		driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(8)")).click();
		
		//double tap/click gesture using map i.e elementId and x & y co-ordinates
		
		System.out.println("double tap/click gesture using map i.e elementId and x & y co-ordinates");
		
		element=driver.findElement(AppiumBy.id("com.fastaguser:id/vehicle_id_txt"));
		element.sendKeys("1111");
		
		int x1=((element.getRect().getX())+(element.getRect().getWidth())/2);
		int y1=((element.getRect().getY())+(element.getRect().getHeight())/2);
		
				
		HashMap<String,Object> map=new HashMap<>();
		map.put("elementId",element);
		map.put("x",x1);
		map.put("y",y1);
		
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",map);
		
		Thread.sleep(5000);
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}

