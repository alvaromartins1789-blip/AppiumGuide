package demo;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
import java.util.HashMap;

public class MobileScrollDemo {
	
	private AndroidDriver driver;
	WebElement element;
	
				
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(priority=1)
	public void test1() throws InterruptedException{
		driver.activateApp("com.freshtohome");
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"bannerImagePress\").instance(7)")).click();
		Thread.sleep(3000);
		element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ScrollView\")"));
		Thread.sleep(3000);
		//Performing scroll, just normal scroll
		System.out.println("Performing scroll, just normal scroll");
		HashMap<String,Object> scrollObject=new HashMap<>();
		scrollObject.put("elementId",((RemoteWebElement)element).getId());
		scrollObject.put("strategy", "-android uiautomator");
		scrollObject.put("selector","text(\"Cabbage Red\")");
				
		driver.executeScript("mobile: scroll",scrollObject);	
	
	}
	@Test(priority=2)
	public void test2() throws InterruptedException{
		
		Thread.sleep(3000);
		//Performing scroll, when element already in viewport.
		System.out.println("Performing scroll, when element already in viewport.");
		HashMap<String,Object> scrollObject=new HashMap<>();
		scrollObject.put("elementId",((RemoteWebElement)element).getId());
		scrollObject.put("strategy", "-android uiautomator");
		scrollObject.put("selector","text(\"Cabbage Red\")");
				
		driver.executeScript("mobile: scroll",scrollObject);	
	
	}
	@Test(priority=3)
	public void test3() throws InterruptedException{
				
		Thread.sleep(3000);
		//Performing scroll, when user don't know the location(i.e. to move upwards or downwards) of the required element.
		System.out.println("Performing scroll, when user don't know the location(i.e. to move upwards or downwards) of the required element.");
		HashMap<String,Object> scrollObject=new HashMap<>();
		scrollObject.put("elementId",((RemoteWebElement)element).getId());
		scrollObject.put("strategy", "-android uiautomator");
		scrollObject.put("selector","text(\"Kiwi - Pack of 3\")");
				
		driver.executeScript("mobile: scroll",scrollObject);	
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Kiwi - Pack of 3\")")).click();
	
	}
	
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


