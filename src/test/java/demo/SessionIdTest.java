package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


/**
 * Script Details - Appium Concepts : How to Fetch/Use 'SessionID' with 'Appium Inspector'-Mobile Automation-Appium2
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class SessionIdTest {
	
	private AndroidDriver driver;
	
	String AUTappPackage="com.wdiodemoapp";
	String AUTappActivity="com.wdiodemoapp.MainActivity";
	
	@BeforeTest
	public void steup() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("device14");
		cap.setAppPackage(AUTappPackage);
		cap.setAppActivity(AUTappActivity);
		cap.setNoReset(true);
		cap.setNewCommandTimeout(Duration.ofSeconds(90));
		
		
				
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");

		}
	}
	
	@Test
	public void sessionidsample() throws InterruptedException {
		Thread.sleep(5000);
		SessionId sessionid_value=driver.getSessionId();
		System.out.println(sessionid_value);
		Thread.sleep(5000);
		
		
		
	}
	

}
