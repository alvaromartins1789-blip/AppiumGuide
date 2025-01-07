package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DevicerotationTest {
	
	private AndroidDriver driver;
	
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
	public void rotationExample() throws InterruptedException {
		//Rotating the device in clockwise direction
		// i.m rotating the device 90 degree i.e right
		System.out.println("Rotating the device in clockwise direction");
		driver.rotate(new DeviceRotation(0, 0, 90));
		System.out.println("device rotate to 90 degree i.e right side");
		Thread.sleep(10000);
		driver.rotate(new DeviceRotation(0, 0, 180));
		System.out.println("device rotate to 180 degree i.e up down side");
		Thread.sleep(10000);
		driver.rotate(new DeviceRotation(0, 0, 270));
		System.out.println("device rotate to 270 degree i.e left side");
		Thread.sleep(10000);
		driver.rotate(new DeviceRotation(0, 0, 0));
		System.out.println("device rotate to 0 degree i.e normal position");
		Thread.sleep(10000);
		
		//Rotating the device in anti-clockwise direction
		// i.m rotating the device 90 degree i.e right
		System.out.println("Rotating the device in anti-clockwise direction");
		driver.rotate(new DeviceRotation(0, 0, 270));
		System.out.println("device rotate to 270 degree i.e left side");
		Thread.sleep(10000);
		driver.rotate(new DeviceRotation(0, 0, 180));
		System.out.println("device rotate to 180 degree i.e up down side");
		Thread.sleep(10000);
		driver.rotate(new DeviceRotation(0, 0, 90));
		System.out.println("device rotate to 90 degree i.e right side");
		Thread.sleep(10000);
		driver.rotate(new DeviceRotation(0, 0, 0));
		System.out.println("device rotate to 0 degree i.e normal position");
		Thread.sleep(10000);
		
		
	}

}
