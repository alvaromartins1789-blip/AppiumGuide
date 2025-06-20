package com.appiumguide.appiumvisualTesting;

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
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;

/**
 * Script Details - Appium-Images : Complete Details On ‘-image’ locator strategy AppiumBy.Image()
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class ImageLocatorDemo {
	
	private AndroidDriver driver;
						
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel9");		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
	
		driver.activateApp("in.burgerking.android");
		Thread.sleep(8000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"BK Recommended\")")).click();
		
		Thread.sleep(5000);
		System.out.println("Click on the Beverages image ");
		imagelocator("Beverages.png");
		Thread.sleep(5000);
		System.out.println("Click on the Snacks image ");
		imagelocator("Snacks.png");
		Thread.sleep(5000);
		System.out.println("Click on the Beverages image ");
		imagelocator("Beverages.png");
			

	}
	
	void imagelocator(String imagedetails) throws IOException {
		
		//Convert the image from file to base64String
		File file=new File(System.getProperty("user.dir")+"/"+imagedetails);
		byte[] filecontent=Files.readAllBytes(file.toPath());
		String base64image=Base64.getEncoder().encodeToString(filecontent);
		
		//Locating Ui element based on image using image locator
		WebElement imageElement=driver.findElement(AppiumBy.image(base64image));
		
		imageElement.click();
		
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


