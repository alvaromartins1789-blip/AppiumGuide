package demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
/**
 * Script Details - How to Run arbitrary ADB commands via Appium {.executeScript("mobile: shell", <arg>)};
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

/*
Scenario's covered:
-----------------------------------------
1. Need to execute all 3 adb shell commands

Note: will follow 3 different styles to provide arguments data

2. To retrieve the result of the ADB call

Note: will follow 2 different styles to retrieve results

//adb shell dumpsys window displays|grep -e 'mCurrentFocus'

*/

public class ArbitraryAdbCommandDemo {
	
	private AndroidDriver driver;
					
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
		
		//adb shell settings put global window_animation_scale 0
		//adb shell settings put global transition_animation_scale 0
		//adb shell settings put global animator_duration_scale 0
		
		//Scenario-1
		System.out.println("Scenario-1");
		
		//To change window_animation_scale to 0
		System.out.println("change window_animation_scale to 0");
		
		driver.executeScript("mobile: shell",ImmutableMap.of(
				"command","settings put global window_animation_scale",
				"args","0"));
		
		//To change transition_animation_scale to 0
		System.out.println("change transition_animation_scale to 0");
		
		Map<String,Object> transition_animation_scale=ImmutableMap.of(
				"command","settings put global transition_animation_scale",
				"args","0");
		
		//To change animator_duration_scale to 0
		System.out.println("change animator_duration_scale to 0");
		driver.executeScript("mobile: shell",transition_animation_scale);
		
		HashMap<String,Object> animator_duration_scale=new HashMap<>();
		animator_duration_scale.put("command","settings put global animator_duration_scale");
		animator_duration_scale.put("args","0");		
		
		driver.executeScript("mobile: shell", animator_duration_scale);
		
		Thread.sleep(3000);
		
		driver.activateApp("io.appium.android.apis");
		
		Thread.sleep(5000);
		
		//Scenario-2
		System.out.println("Scenario-2");
		//Running the '//adb shell dumpsys window displays|grep -e 'mCurrentFocus' to fetch appPackege & appActivity details
		
		System.out.println("Running the '//adb shell dumpsys window displays|grep -e 'mCurrentFocus' to fetch appPackege & appActivity details");
		Object Output1=driver.executeScript("mobile: shell",ImmutableMap.of(
				"command","dumpsys window displays|grep -e",
				"args","'mCurrentFocus'"));
		System.out.println("Output1 value- "+Output1.toString());
		
		//adb shell dumpsys window displays|grep -e 'mCurrentFocus'
		
		String Output2=(String) driver.executeScript("mobile: shell",ImmutableMap.of(
				"command","dumpsys window displays|grep -e",
				"args","'mCurrentFocus'"));
		System.out.println("Output1 value- "+Output2);
		
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


