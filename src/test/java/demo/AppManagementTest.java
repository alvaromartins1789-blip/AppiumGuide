package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Script Details - Appium Concepts : Complete Details on ‘Appium App Management’ Methods
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class AppManagementTest {
	
	private AndroidDriver driver;
	 String app_package="com.wdiodemoapp";
		
	@BeforeTest
	public void steup() throws MalformedURLException {
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
			driver.quit();
			System.out.println("Test Execution Completed");
		}
	}
	
	@Test
	public void sessionidsample() throws InterruptedException {
		Thread.sleep(5000);
		
		
		if(driver.isAppInstalled(app_package)) {
			System.out.println("Intially wdio app is already installed");
		}else{
			System.out.println("Intially wdio app is not installed");
			driver.installApp(System.getProperty("user.dir")+"/APK_Files/android.wdio.native.app.v1.0.8.apk");
		}
		Thread.sleep(5000);
		driver.activateApp(app_package);
		System.out.println("wdio app is activated/opened");
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(15));
		System.out.println("wdio app is running in the background");
		Thread.sleep(5000);
		driver.terminateApp(app_package);
		System.out.println("wdio app is closed");
		Thread.sleep(5000);
		driver.activateApp(app_package);
		System.out.println("wdio app is opened once again");
		Thread.sleep(15000);
		driver.removeApp(app_package);
		System.out.println("wdio app is uninstalled");
		
	}
	

}

