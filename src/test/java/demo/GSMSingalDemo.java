package demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
/**
 * Script Details - Appium command to manage “Signal Strength” Using (UiAutomator2 driver(emulators)) - ‘mobile: gsmSignal’
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */
public class GSMSingalDemo {
	
	private AndroidDriver driver;
					
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8");		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		//Scenario - 1 Change Signal Strength from '0' to '4'
		System.out.println("Scenario - 1 Change Signal Strength from '0' to '4'");
		
		//Change the signal strength to '0' i.e none
		System.out.println("Change the signal strength to '0' i.e none");
		
		driver.executeScript("mobile: gsmSignal",ImmutableMap.of(
				"strength","0"));
		
		Thread.sleep(10000); // pause the script for 10 seconds, the signal strength will reflect in the emulator
		
		//Change the signal strength to '4' i.e great
		System.out.println("Change the signal strength to '0' i.e great");
		
		driver.executeScript("mobile: gsmSignal",ImmutableMap.of(
				"strength","4"));
		
		Thread.sleep(10000); // pause the script for 10 seconds, the signal strength will reflect in the emulator
		
		//Scenario - 2 Change the signal strength from '0' i.e 'none' to '4' i.e great
		System.out.println("Scenario - 2 Change the signal strength from '0' i.e 'none' to '4' i.e great");
		
		for(int i=0;i<=4;i++) {
			driver.executeScript("mobile: gsmSignal",ImmutableMap.of(
					"strength",i));
			System.out.println("Change the signal strength to - "+i);
			Thread.sleep(10000); // pause the script for 10 seconds, the signal strength will reflect in the emulator
		}

	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


