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

public class LongPressW3CMobileGestureDemo {
	
	private AndroidDriver driver;	
	WebElement ele;	
		
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
	public void test1() throws InterruptedException {
		
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		ele=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId()));
		
		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		ele=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Fish Names\")"));
		
		int x=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y=((ele.getRect().getY())+(ele.getRect().getHeight())/2);
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId()),
				"x",x,
				"y",y);
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		ele=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Cat Names\")"));
		
		int x1=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y1=((ele.getRect().getY())+(ele.getRect().getHeight())/2);
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",ImmutableMap.of(
				"x",x1,
				"y",y1));
		Thread.sleep(3000);

		driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		ele=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Dog Names\")"));
		
		int x2=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y2=((ele.getRect().getY())+(ele.getRect().getHeight())/2);
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId()),
				"x",x2,
				"y",y2,
				"duration","1000");		
	}			
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}


