
package com.appiumguide.capabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - "Appium Capabilities” - Complete Details on “Appium-Session Creation or Mandatory Capabilities”
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class SessionCapabilitiesDemo {
	
	private AndroidDriver driver;
	
								
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		UiAutomator2Options caps=new UiAutomator2Options();
		try {
			
			//define Session Creation Capabilities
			System.out.println("//define Session Creation Capabilities");
								caps.setPlatformName("Android");
								
								caps.setAutomationName("UiAutomator2");
								
								//caps.setDeviceName("Pixel6");
								caps.setUdid("emulator-5554");
								
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
						
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() {
		
		System.out.println("Current Session ID Details -" +driver.getSessionId());
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}

