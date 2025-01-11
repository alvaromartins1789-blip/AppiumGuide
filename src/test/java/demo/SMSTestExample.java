package demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class SMSTestExample {
	private AndroidDriver driver;
	
	@BeforeTest
	public void stepup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("device14");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		
	}
	
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");

		}
	}
	
	@Test
	public void SMSTest() throws InterruptedException {
		
		//send SMS message
		driver.sendSMS("1234567890", "hi Appiumguide");
		
		Thread.sleep(10000);
		
		driver.sendSMS("5555555555", "Hi login OTP is '123456',please use given OTP to login");
		
	}
	
}
