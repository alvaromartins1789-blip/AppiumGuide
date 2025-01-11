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
 * Script Details - How to Perform "Scroll"Gesture-Multiple Scrolling:Based on elementId & Direction–Up/Down
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class MultipleScrollDemo {
	
	private AndroidDriver driver;
	boolean canSrcollMore;
			
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
		
		driver.activateApp("in.burgerking.android");
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Value Meals\")")).click();
		Thread.sleep(3000);
		WebElement element1=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(24)"));
		
		WebElement element2=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(69)"));
		
		Thread.sleep(5000);
		//performing scroll on element-1,direction - down
		System.out.println("performing scroll on element-1,direction - down");
		
		canSrcollMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of(
				"elementId",((RemoteWebElement)element1).getId(),
				"direction","down",
				"percent","1.0"
				));
		Thread.sleep(3000);
		//performing scroll on element-2,direction - down
		System.out.println("performing scroll on element-2,direction - down");
				
		canSrcollMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of(
					"elementId",((RemoteWebElement)element2).getId(),
					"direction","down",
					"percent","1.0"
					));
		Thread.sleep(3000);
		//performing scroll on element-1,direction - up
				System.out.println("performing scroll on element-1,direction - up");
				
				canSrcollMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of(
						"elementId",((RemoteWebElement)element1).getId(),
						"direction","up",
						"percent","1.0"
						));
		Thread.sleep(3000);		
		//performing scroll on element-2,direction - up
		System.out.println("performing scroll on element-2,direction - up");
				
		canSrcollMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of(
					"elementId",((RemoteWebElement)element2).getId(),
					"direction","up",
					"percent","1.0"
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

