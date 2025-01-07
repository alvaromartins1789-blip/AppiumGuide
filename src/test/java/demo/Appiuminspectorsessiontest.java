package demo;

//This sample code supports Appium Java client >=9
//https://github.com/appium/java-client
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Appiuminspectorsessiontest {

private AndroidDriver driver;

@BeforeTest
public void setUp() throws MalformedURLException {
	
	UiAutomator2Options options=new UiAutomator2Options();
	
   options.setCapability("platformName", "android");
   options.setCapability("appium:automationName", "uiautomator2");
   options.setCapability("appium:appPackage", "com.wdiodemoapp");
   options.setCapability("appium:appActivity", "com.wdiodemoapp.MainActivity");
   options.setCapability("appium:noReset", true);
   options.setCapability("appium:ensureWebviewsHavePages", true);
   options.setCapability("appium:nativeWebScreenshot", true);
   options.setCapability("appium:newCommandTimeout", 3600);
   options.setCapability("appium:connectHardwareKeyboard", true);


 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
}

@Test
public void sampleTest() {
	System.out.println(driver.getSessionId());

}

@AfterTest
public void tearDown() {
 //driver.quit();
}
}

