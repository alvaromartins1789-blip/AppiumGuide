package com.appiumguide.appiumconcepts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class PullFolderDemo {
	
	private AndroidDriver driver;
						
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8");		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		
		//.pullFolder(String remotepath)
		//Pull sample.zip folder from test device & Saved as "downloaded_sample.zip" in our local machine
		System.out.println("Pull sample.zip folder from test device & Saved as \"downloaded_sample.zip\" in our local machine");
		byte[] pulledZipFolder=driver.pullFolder("/sdcard/download/sample.zip");
		Files.write(Paths.get("downloaded_sample.zip"), pulledZipFolder);
		System.out.println("Folder pulled from the device & Saved as downloaded_sample.zip ");

	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


