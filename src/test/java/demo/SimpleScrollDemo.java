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

public class SimpleScrollDemo {
	
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
				
			driver.activateApp("in.burgerking.android");
			Thread.sleep(3000);
			driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"BK Recommended\")")).click();
			Thread.sleep(3000);
			WebElement element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(69)"));
			//Perform scroll towards down direction
			System.out.println("Perform scroll towards down direction");
			int speedvalue=(int)(5000*2.625);
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of("elementId",
					((RemoteWebElement)element).getId(),
					"direction","down",
					"percent",1.0, //75% = 0.75,50% = 0.5,100%= 1.0
					"speed",speedvalue)); 
			
			Thread.sleep(3000);
			//Perform scroll towards up direction
			System.out.println("Perform scroll towards up direction");
			((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of("elementId",
					((RemoteWebElement)element).getId(),
					"direction","up",
					"percent",1.0 //75% = 0.75,50% = 0.5,100%= 1.0
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




