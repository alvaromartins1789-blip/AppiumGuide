package demo;

import java.time.Duration;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.net.*;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class ScreenRecordingTest {
	
	private AndroidDriver driver;
	
	String app_package="io.appium.android.apis";
	String app_activity="io.appium.android.apis.ApiDemos";
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		cap.setAppPackage(app_package);
		cap.setAppActivity(app_activity);
		cap.setNoReset(true);
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(priority=1)
	public void recordtest1() throws IOException, InterruptedException {
		
		
		//Screen Recording with default options
		Thread.sleep(5000);
		driver.startRecordingScreen();
		
		System.out.println("Started Screen Recording with default options");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		driver.findElement(AppiumBy.accessibilityId("3D Transition")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Lyon\")")).click();
		
		String record=driver.stopRecordingScreen();
		Thread.sleep(5000);
		byte[] encode=Base64.getDecoder().decode(record);
		FileUtils.writeByteArrayToFile(new File("recordingclip1.mp4"), encode);
		System.out.println("Screen Recording Stopped");
		
		driver.terminateApp(app_package);
		
	}
	@Test(priority=2)
	public void recordtest2() throws InterruptedException, IOException {
		
		//Screen Recording with options
		Thread.sleep(5000);
		driver.activateApp(app_package);
				Thread.sleep(5000);
				driver.startRecordingScreen(new AndroidStartScreenRecordingOptions().disableForcedRestart().withBitRate(10000000).withVideoSize("640x480").withTimeLimit(Duration.ofSeconds(60)).enableBugReport());
				
				System.out.println("Started Screen Recording with options-bitrate -10mb/sec,videosize-640X480,withBugReport");
				
				driver.findElement(AppiumBy.accessibilityId("Views")).click();
				
				driver.findElement(AppiumBy.accessibilityId("Animation")).click();
				driver.findElement(AppiumBy.accessibilityId("3D Transition")).click();
				
				driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Livermore\")")).click();
				Thread.sleep(5000);
				String record=driver.stopRecordingScreen();
				byte[] encode=Base64.getDecoder().decode(record);
				FileUtils.writeByteArrayToFile(new File("recordingclip2.mp4"), encode);
				System.out.println("Screen Recording Stopped");
				
				driver.terminateApp(app_package);
	}
	
	@Test(priority=3)
	public void recordtest3() throws InterruptedException, IOException {
		
		//Screen Recording with options
		Thread.sleep(5000);
		driver.activateApp(app_package);
				Thread.sleep(5000);
				
				driver.startRecordingScreen(new AndroidStartScreenRecordingOptions().withTimeLimit(Duration.ofSeconds(10)).withBitRate(10000000).withVideoSize("1280x720"));
				
				System.out.println("Started Screen Recording with options-bitrate -10mb/sec,videosize-1280X720,withoutBugReport");
				
				driver.findElement(AppiumBy.accessibilityId("Views")).click();
				
				driver.findElement(AppiumBy.accessibilityId("Animation")).click();
				driver.findElement(AppiumBy.accessibilityId("3D Transition")).click();
				
				driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Grand Canyon\")")).click();
				Thread.sleep(5000);
				String record=driver.stopRecordingScreen();
				
				byte[] encode=Base64.getDecoder().decode(record);
				FileUtils.writeByteArrayToFile(new File("recordingclip3.mp4"), encode);
				System.out.println("Screen Recording Stopped");
	}
	
	
	@AfterClass
	public void teardown() {
		if(driver!=null) {
			driver.terminateApp(app_package);
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}

}
