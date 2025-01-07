package demo1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Test001 {
private AndroidDriver driver;
	
	String AUTappPackage="com.appiumpro.the_app";
	String AUTappActivity="com.appiumpro.the_app.MainActivity";
	
	@BeforeTest
	public void steup() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setAppPackage(AUTappPackage);;
		cap.setAppActivity(AUTappActivity);	
		cap.setAutoGrantPermissions(true);
		//cap.setIsHeadless(Boolean.parseBoolean (System.getProperty ("headless", "true")));
		//cap.setCapability("appium:avd","device11");	
		cap.setDeviceName("Pixel8Pro");
		cap.setCapability("appium:isHeadless","true");	
		
		
		
	   
		//FC100
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
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Login Screen\")")).click();
		WebElement ele=driver.findElement(AppiumBy.accessibilityId("username"));
		ele.sendKeys("armesh");
		Thread.sleep(5000);
		String s=ele.getText();
		System.out.println(s);
		
		
	}
	

}