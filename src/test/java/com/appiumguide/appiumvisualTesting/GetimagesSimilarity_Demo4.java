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
 * Script Details - Appium-Visual Testing (Part-4): Complete Details On Appium Built-in method "getImagesSimilarity(File image1, File image2, SimilarityMatchingOptions options)"
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class GetimagesSimilarity_Demo4 {
	
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
		
		//Step 1: Capture the Screenshot in file format
		System.out.println("Step 1: Capture the Screenshot in file format");
		
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("actual_image"+".png"));
		
		File file1=new File(System.getProperty("user.dir")+"/actual_image.png");
		File file2=new File(System.getProperty("user.dir")+"/Expected_image.png");
		
		//Step 2: Create SimilarityMatchingOptions Options
		System.out.println("Step 2: Create SimilarityMatchingOptions Options");
		
		SimilarityMatchingOptions options=new SimilarityMatchingOptions().withEnabledVisualization();
		
		//Step 3: Perform the Comparison
		System.out.println("Step 3: Perform the Comparison");
		
		SimilarityMatchingResult result=driver.getImagesSimilarity(file1, file2, options);
		
		//Step 4: Calculate the Score & Print the Result
		System.out.println("Step 4: Calculate the Score & Print the Result");
		
		System.out.println("Similarity Scrore : "+result.getScore());
		
		//Step 5: Generate/Analyze a visual_diff image
		System.out.println("Step 5: Generate/Analyze a visual_diff image");
		
		if(result.getVisualization()!=null) {
			byte[] vis=Base64.getDecoder().decode(result.getVisualization());
			Files.write(new File("visual_diff.png").toPath(), vis);
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

