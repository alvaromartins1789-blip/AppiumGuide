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

public class FlingDownDemo {
	
	private AndroidDriver driver;
	
			
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
			driver.activateApp("com.android.vending");
			Thread.sleep(3000);
			
			driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			Thread.sleep(3000);
			
			WebElement element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(1)"));
			
			//perform fling gesture based on element & direction is down
			System.out.println("perform fling gesture based on element & direction is down");
			
			int speedvalue=(int)(7500*2.625);
			
			boolean canFlingMore=(boolean)((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
					"elementId",((RemoteWebElement)element).getId(),
					"direction","down",
					"speed",speedvalue));
				
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}


