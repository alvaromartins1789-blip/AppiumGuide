
package demo3;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ActiveSessionTest {
	
	private AndroidDriver driver;
	
	String AUTappPackage="com.fastaguser";
	String AUTappActivity="com.fastaguser.newui.InteractiveActivity";
	
	
	@BeforeTest
	public void steup() throws IOException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		cap.setAppPackage(AUTappPackage);
		cap.setAppActivity(AUTappActivity);
		cap.setNoReset(true);	
						
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
	public void ActiveSessionsample() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.fastaguser:id/nhaionlinenew\"]/android.widget.LinearLayout/android.widget.ImageView")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fastaguser:id/branch_company_name\" and @text=\"Amazon\"]")).click();
		Thread.sleep(5000);
		SessionId sessionid_value=driver.getSessionId();
		System.out.println("Session id1 - "+sessionid_value);
		driver.terminateApp(AUTappPackage);
			
		
	}
	

}
