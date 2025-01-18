package demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - Appium Concepts | Appium command-To Get device “date and time” for both iOS & Android
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class DeviceDateTimeDemo {
	
	private AndroidDriver driver;
	
	String device_datetime;
					
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
		
		//Get the Device Date & Time
		device_datetime=driver.getDeviceTime();
		System.out.println("Get the Device Date & Time - "+device_datetime);
		
		//Get Device Date in required format
		device_datetime=driver.getDeviceTime("YYYY");
		System.out.println("Get the Device Date(formatted) YYYY - "+device_datetime);		
				
		device_datetime=driver.getDeviceTime("YY");
		System.out.println("Get the Device Date(formatted) YY- "+device_datetime);	
		
		device_datetime=driver.getDeviceTime("MM");
		System.out.println("Get the Device Date(formatted) MM- "+device_datetime);	
		
		device_datetime=driver.getDeviceTime("DD");
		System.out.println("Get the Device Date(formatted) DD- "+device_datetime);	
		
		
		//Get Device Time in required format
		device_datetime=driver.getDeviceTime("HH");
		System.out.println("Get the Device Time(formatted) HH - "+device_datetime);		
				
		device_datetime=driver.getDeviceTime("mm");
		System.out.println("Get the Device Time(formatted) mm- "+device_datetime);	
		
		device_datetime=driver.getDeviceTime("ss");
		System.out.println("Get the Device Time(formatted) ss- "+device_datetime);	
		
		device_datetime=driver.getDeviceTime("Z");
		System.out.println("Get the Device Time(formatted) Z(zone)- "+device_datetime);
		
		device_datetime=driver.getDeviceTime("T");
		System.out.println("Get the Device Time(formatted) T- "+device_datetime);
		
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}


