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

public class FlingDemo {
	
	private AndroidDriver driver;
	WebElement element;
	boolean canFlingMore;
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
			driver.activateApp("net.organicbazar");	
			Thread.sleep(3000);
			driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)")).click();
			Thread.sleep(3000);
			driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)")).click();
			Thread.sleep(3000);
			element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\")"));
			//Fling to Right(direction)
			System.out.println("Fling to Right(direction)");
			
			canFlingMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
					"elementId",((RemoteWebElement)element).getId(),
					"direction","right",
					"speed",2500
					));
			
			Thread.sleep(3000);
			//Fling to Left(direction)
			System.out.println("Fling to Left(direction)");
			speedvalue=(int)(7500*2.625);
			
			((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
					"elementId", ((RemoteWebElement)element).getId(),
					"direction","left",
					"speed",speedvalue
					));
			Thread.sleep(3000);
			//enhance fling right with loop
			System.out.println("enhance fling right with loop");
			speedvalue=(int)(500*2.625);
			for(int i=1;i<6;i++) {	
			canFlingMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
					"elementId",((RemoteWebElement)element).getId(),
					"direction","right",
					"speed",2500
					));
			}
			Thread.sleep(3000);
			//enhance fling left with loop
			System.out.println("enhance fling left with loop");
			
			for(int i=1;i<6;i++) {	
			canFlingMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
					"elementId",((RemoteWebElement)element).getId(),
					"direction","left"				
					));
			}
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}

