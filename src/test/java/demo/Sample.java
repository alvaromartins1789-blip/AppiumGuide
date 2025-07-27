
package demo;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.Response;

public class Sample {
	
	private AndroidDriver driver;
	
								
	@BeforeTest
	public void setup2() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setUdid("emulator-5554");
		//cap.amend("appium:plugin","ocr");
		cap.skipDeviceInitialization();
		cap.skipServerInstallation();
		cap.setAppPackage(null);
		cap.setAppActivity(null);
									
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void test1() throws InterruptedException, IOException {
		driver.context("OCR");
		

		// Find the element with OCR text 'Invalid email address'
		WebElement invalidEmailMessage = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"Home-screen\"]/android.view.ViewGroup/android.widget.ImageView[1]"));

		// Check if the element is displayed
		if (invalidEmailMessage.isDisplayed()) {
		    System.out.println("Successfully validated that the error message is displayed");
		} else {
		    System.out.println("The error message is not present");
		}
		 
    }
				
				
	
	
	@AfterTest
	public void teardown2() {
		
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}

