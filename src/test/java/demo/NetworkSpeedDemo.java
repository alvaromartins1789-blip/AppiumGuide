
package demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class NetworkSpeedDemo {
	
	private AndroidDriver driver;
				
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		cap.setNetworkSpeed("lte");
		//or
		cap.setCapability("networkSpeed","lte"); //lte
		cap.setCapability("networkSpeed","gsm"); //gsm
		cap.setCapability("networkSpeed","egde"); //edge
		cap.setCapability("networkSpeed","full"); //full
		cap.setCapability("networkSpeed","gprs"); //gprs
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void test() {
		
		driver.executeScript("mobile: networkSpeed",ImmutableMap.of("speed","lte"));
		driver.executeScript("mobile: networkSpeed",ImmutableMap.of("speed","gsm"));
		driver.executeScript("mobile: networkSpeed",ImmutableMap.of("speed","full"));
		driver.executeScript("mobile: networkSpeed",ImmutableMap.of("speed","edge"));
		driver.executeScript("mobile: networkSpeed",ImmutableMap.of("speed","evdo"));
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");

		}
		
	}
	

}


