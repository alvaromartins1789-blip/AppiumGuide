package demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

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
	driver.quit();
	System.out.println("Test Execution Completed");
}
}

