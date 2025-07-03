package demo;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.Map;

/**
 * Script Details - Appium-Visual Testing (Part-2): Complete Details On .getImagesSimilarity(byte[] base64image1, byte[] base64Image2,SimilarityMatchingOptions options)
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */


public class sample4 {
	
	private AndroidDriver driver;
								
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		//cap.setDeviceName("Pixel6");		
					
		
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
            System.out.println("Appium driver session started successfully!");
        } catch (MalformedURLException e) {
            System.err.println("URL is malformed: " + e.getMessage());
        } catch (SessionNotCreatedException e) {
            System.err.println("Session could not be created. Check your capabilities: " + e.getMessage());
        } catch (InvalidArgumentException e) {
            System.err.println("Invalid argument in capabilities: " + e.getMessage());
        } catch (WebDriverException e) {
            System.err.println("WebDriver-related error (possibly Appium server/device issue): " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error occurred: " + e.getMessage());
        }
		
		
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		
		System.out.println("hi");
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


