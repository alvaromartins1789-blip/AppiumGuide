package com.appiumguide.appiumconcepts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.Base64;

/**
 * Script Details - Appium Concepts - How to Capture a "Screen Shot" by using in-built - "getScreenshotAs" method
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class TakesScreenShotDemo {
	
	private AndroidDriver driver;
	
	File scrFile,targetFile;
				
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test
	public void sampletest() throws IOException, InterruptedException {
		
		driver.activateApp("com.wdiodemoapp");
		//Screenshot based on outputtype file
		System.out.println("Screenshot based on outputtype file");
		scrFile=driver.getScreenshotAs(OutputType.FILE);
		targetFile=new File("outputtype_file"+".png");
		FileUtils.copyFile(scrFile, targetFile);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Drag\")")).click();
		
		Thread.sleep(3000);
		//Screenshot based on outputtype bytes
		System.out.println("Screenshot based on outputtype bytes");
		byte[] srcFile=driver.getScreenshotAs(OutputType.BYTES);
		targetFile=new File("outputtype_bytes"+".png");
		FileUtils.writeByteArrayToFile(targetFile, srcFile);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Swipe\")")).click();
		Thread.sleep(3000);
		
		//Screenshot based on outputtype bytes
		System.out.println("Screenshot based on outputtype Base64");
		byte[] byteArray;
		String scrFile1=driver.getScreenshotAs(OutputType.BASE64);
		FileOutputStream fos=new FileOutputStream("outputtype_base64"+".png");
		byteArray=Base64.getDecoder().decode(scrFile1);
		fos.write(byteArray);		
		
	}
			
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");

		}
		
	}
	

}



