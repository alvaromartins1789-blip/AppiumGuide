package com.appiumguide.appiumimages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;

/**
 * Script Details - Appium-Visual Testing : Complete Details On .getImagesSimilarity driver.getImagesSimilarity(byte[], byte[])
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class GetimagesSimilarity_Demo1 {
	
	private AndroidDriver driver;
	File screenshot;
						
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
		
		driver.activateApp("com.wdiodemoapp");
		Thread.sleep(5000);
		
		//Step 1: Capture the Screenshot
		System.out.println("Step 1: Capture the Screenshot");
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("actual_image"+".png"));
		
		Thread.sleep(5000);
		
		//Step 2: Covert the file to base64image
		System.out.println("Step 2: Covert the file to base64image");
		
		byte[] img1Bytes=Files.readAllBytes(new File(System.getProperty("user.dir")+"/actual_image.png").toPath());
		byte[] img2Bytes=Files.readAllBytes(new File(System.getProperty("user.dir")+"/Expected_image.png").toPath());
		
		byte[] base64Images1=Base64.getEncoder().encode(img1Bytes);
		byte[] base64Images2=Base64.getEncoder().encode(img2Bytes);
		
		//Step 3: Perform the Comparison
		
		System.out.println("Step 3: Perform the Comparison");
		
		//System.out.println(driver.getImagesSimilarity(base64Images1, base64Images2).getScore());
		
		SimilarityMatchingResult result=driver.getImagesSimilarity(base64Images1, base64Images2);
		
		//Step 4: Print the Result
		System.out.println("Step 4: Print the Result");
		
		System.out.println("Similarity Scrore of the Images - " +result.getScore());

        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}

