package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class OrientationTest {
	
	private AndroidDriver driver;
	ScreenOrientation currentorientation;
	@BeforeTest
	public void steup() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixal7a");
		cap.setAppPackage("com.google.android.deskclock");
		cap.setAppActivity("com.android.deskclock.DeskClock");
		//cap.setOrientation(currentorientation.LANDSCAPE);
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
	}
	@Test
	public void orientationexampl() throws InterruptedException {
		
		
		currentorientation=driver.getOrientation();
		System.out.println("Current Orientation - "+currentorientation);
		Thread.sleep(5000);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Thread.sleep(5000);
		driver.rotate(ScreenOrientation.PORTRAIT);
		
		
	}
	

}
