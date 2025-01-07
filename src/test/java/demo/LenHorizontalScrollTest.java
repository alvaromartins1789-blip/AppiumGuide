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

public class LenHorizontalScrollTest {
	
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
			//driver.quit();
		}
		
	}
	

}
