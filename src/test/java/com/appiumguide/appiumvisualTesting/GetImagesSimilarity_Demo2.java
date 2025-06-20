package com.appiumguide.appiumvisualTesting;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;

/**
 * Script Details - Appium-Visual Testing (Part-2): Complete Details On .getImagesSimilarity(byte[] base64image1, byte[] base64Image2,SimilarityMatchingOptions options)
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */


public class GetImagesSimilarity_Demo2 {
	
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
		
		//Launch thw wdiodemo app
		driver.activateApp("com.wdiodemoapp");
		Thread.sleep(5000);
		
		//Step 1: Capture the Screenshot
		System.out.println("Step 1: Capture the Screenshot");
		
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("actual_image"+".png"));
		Thread.sleep(5000);
		
		//Step 2: Convert the file to base64image
		System.out.println("Step 2: Convert the file to base64image");
		byte[] img1Bytes=Files.readAllBytes(new File(System.getProperty("user.dir")+"/actual_image.png").toPath());
		byte[] img2Bytes=Files.readAllBytes(new File(System.getProperty("user.dir")+"/Expected_image.png").toPath());
		
		byte[] base64Image1=Base64.getEncoder().encode(img1Bytes);
		byte[] base64Image2=Base64.getEncoder().encode(img2Bytes);
		
		//Step 3: Create SimilarityMatchingOptions
		System.out.println("Step 3: Create SimilarityMatchingOptions");
		
		SimilarityMatchingOptions options=new SimilarityMatchingOptions().withEnabledVisualization();
		
		//Step 4: Perform the Comparison
		System.out.println("Step 4: Perform the Comparison");
		
		SimilarityMatchingResult result=driver.getImagesSimilarity(base64Image1, base64Image2, options);
		Thread.sleep(5000);
		
		//Step 5: Print the Result
		System.out.println("Step 5: Print the Result");
		
		System.out.println("Similarity Score - : "+result.getScore());
		
		//Step 6: Visualize the difference 
		System.out.println("Step 6: Visualize the difference");
		
		if(result.getVisualization()!=null) {
			byte[] vis=Base64.getDecoder().decode(result.getVisualization());
			Files.write(new File("visual_diff.png").toPath(),vis);
		}
		
		
		
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


