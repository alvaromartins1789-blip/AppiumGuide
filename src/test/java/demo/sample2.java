package demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.imagecomparison.FeaturesMatchingOptions;
import io.appium.java_client.imagecomparison.FeaturesMatchingResult;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;
import java.util.List;

/**
 * Script Details - Appium-Visual Testing (Part-2): Complete Details On .getImagesSimilarity(byte[] base64image1, byte[] base64Image2,SimilarityMatchingOptions options)
 * 
 * appium-java-client version: Latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */


public class sample2 {
	
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
		driver.activateApp("in.burgerking.android");
		Thread.sleep(10000);
		
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
		System.out.println("Step 3: Create FeaturesMatchingOptions");
		
		FeaturesMatchingOptions options=new FeaturesMatchingOptions()
				.withEnabledVisualization();				
		
		//Step 4: Perform the Comparison
		System.out.println("Step 4: Perform the Comparison");
		
		FeaturesMatchingResult result=driver.matchImagesFeatures(base64Image1, base64Image2,options);
		Thread.sleep(5000);
		System.out.println("=== FeaturesMatchingResult ===");
        System.out.println("Matched Points Count: " + result.getCount());
        System.out.println("Total Keypoints in Source Image: " + result.getTotalCount());

        Rectangle rect1 = result.getRect1();
        Rectangle rect2 = result.getRect2();
        System.out.println("Match Rectangle in Image 1: " + rect1);
        System.out.println("Match Rectangle in Image 2: " + rect2);

        List<Point> points1 = result.getPoints1();
        List<Point> points2 = result.getPoints2();
        System.out.println("Matched Points in Image 1: " + points1);
        System.out.println("Matched Points in Image 2: " + points2);
        /*
        FeaturesMatchingOptions options=new FeaturesMatchingOptions().
        // 5. Save visualization image (Base64 to PNG)
        Thread.sleep(5000);  
        */     
                
        if(result.getVisualization()!=null) {
        	byte[] visualization = result.getVisualization();
			byte[] vis=Base64.getDecoder().decode(visualization);
			Files.write(new File("match_visualization.png").toPath(),vis);
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


