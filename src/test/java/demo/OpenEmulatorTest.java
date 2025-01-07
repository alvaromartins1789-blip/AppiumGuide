package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class OpenEmulatorTest {
private AndroidDriver driver;
	
	String AUTappPackage="com.fastaguser";
	String AUTappActivity="com.fastaguser.newui.InteractiveActivity";
	
	@BeforeTest
	public void steup() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		
		cap.setAppPackage(AUTappPackage);
		cap.setAppActivity(AUTappActivity);
		cap.setNoReset(true);
		cap.setCapability("appium:avd","device11");	
		cap.setDeviceName("device11");
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
		SessionId sessionid_value=driver.getSessionId();
		System.out.println(sessionid_value);
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.fastaguser:id/nhaionlinenew\"]/android.widget.LinearLayout/android.widget.ImageView")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fastaguser:id/branch_company_name\" and @text=\"Amazon\"]")).click();
		
		
	}
	

}