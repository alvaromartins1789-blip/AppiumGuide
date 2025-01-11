package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Script Details - Appium Concepts : How to Switch(Interact) between 3 Apps(Native/WebBrowser)-MobileAutomation
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class SwitchAppsTest {
	
	private AndroidDriver driver;
	
	String AUTappPackage="com.fastaguser";
	String AUTappActivity="com.fastaguser.newui.InteractiveActivity";
	
	@BeforeTest
	public void steup() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("device11");
		cap.setAppPackage(AUTappPackage);
		cap.setAppActivity(AUTappActivity);
		cap.setNoReset(true);
		
				
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
	public void switchappexample() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.fastaguser:id/nhaionlinenew\"]/android.widget.LinearLayout/android.widget.ImageView")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fastaguser:id/branch_company_name\" and @text=\"Amazon\"]")).click();
		String AmazonappPackage=driver.getCurrentPackage();
		String AmazonappActivity=driver.currentActivity();
		System.out.println("Amazon appPackage - "+AmazonappPackage);
		System.out.println("Amazon appActivity - "+AmazonappActivity);
		Thread.sleep(5000);
		driver.executeScript("mobile:startActivity",ImmutableMap.of("intent",AUTappPackage+"/"+AUTappActivity));
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fastaguser:id/branch_company_name\" and @text=\"Flipkart\"]")).click();
		String chromeappPackage=driver.getCurrentPackage();
		String chromeappActivity=driver.currentActivity();
		
		System.out.println("Chrome appPackage - "+chromeappPackage);
		System.out.println("Chrome appActivity - "+chromeappPackage);
		Thread.sleep(5000);
		driver.executeScript("mobile:startActivity", ImmutableMap.of("intent",AUTappPackage+"/"+AUTappActivity));
		Thread.sleep(5000);
		driver.executeScript("mobile:startActivity", ImmutableMap.of("intent",AmazonappPackage+"/"+AmazonappActivity));
		Thread.sleep(5000);
		driver.executeScript("mobile:startActivity", ImmutableMap.of("intent",chromeappPackage+"/"+chromeappActivity));
		Thread.sleep(5000);
		driver.executeScript("mobile:startActivity", ImmutableMap.of("intent",AUTappPackage+"/"+AUTappActivity));		
		
	}

}
