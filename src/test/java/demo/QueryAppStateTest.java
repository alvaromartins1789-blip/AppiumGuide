package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;

public class QueryAppStateTest {
	
	private AndroidDriver driver;
	
	String app_Package="com.wdiodemoapp";
	ApplicationState appstatevalue;
		
	@BeforeTest
	public void stepup() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
				
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
	}
	
	@Test
	public void sessionidsample() throws InterruptedException {
		Thread.sleep(5000);
		//Before installing the WDIO app
		appstatevalue=driver.queryAppState(app_Package);
		System.out.println("Before installing the WDIO app - "+appstatevalue);
		Thread.sleep(5000);
		
		//After installing the WDIO app
		
		driver.installApp(System.getProperty("user.dir")+"/APK_Files/android.wdio.native.app.v1.0.8.apk");
		appstatevalue=driver.queryAppState(app_Package);
		System.out.println("After installing the WDIO app,but not opened - "+appstatevalue);
		Thread.sleep(5000);
		
		//open the app which active on the mobile screen
		driver.activateApp(app_Package);
		appstatevalue=driver.queryAppState(app_Package);
		System.out.println("open the app which active on the mobile screen - "+appstatevalue);
		Thread.sleep(5000);
		
		//Running the WDIO app in background
		driver.executeScript("mobile:startActivity", ImmutableMap.of("intent", "com.google.android.deskclock/com.android.deskclock.DeskClock"));
		appstatevalue=driver.queryAppState(app_Package);
		System.out.println("WDIO app is running background - "+appstatevalue);
		Thread.sleep(5000);
		
		//open the app which active on the mobile screen
		driver.activateApp(app_Package);
		appstatevalue=driver.queryAppState(app_Package);
		System.out.println("open the app which active on the mobile screen - "+appstatevalue);
		Thread.sleep(5000);
		
		//Close the app
		driver.terminateApp(app_Package);
		appstatevalue=driver.queryAppState(app_Package);
		System.out.println("WDIO app is closed/not running - "+appstatevalue);
		
		
	}
	

}

