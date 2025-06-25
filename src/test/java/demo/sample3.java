package demo;

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


public class sample3 {
	
	private AndroidDriver driver;
	File screenshot;
							
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel6");		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException {
		
			
		/*
		// Read base64 images
		
		//Step 1: Capture the Screenshot
				System.out.println("Step 1: Capture the Screenshot");
				FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("logo"+".png"));
				Thread.sleep(5000);
				
		byte[] img1Bytes=Files.readAllBytes(new File(System.getProperty("user.dir")+"/logo1.png").toPath());
		byte[] img2Bytes=Files.readAllBytes(new File(System.getProperty("user.dir")+"/logo.png").toPath());
		
		byte[] fullImg=Base64.getEncoder().encode(img2Bytes);
		byte[] partImg=Base64.getEncoder().encode(img1Bytes);

		// Set options
		
		OccurrenceMatchingOptions options = new OccurrenceMatchingOptions().withEnabledVisualization();

		// Find match
		System.out.println("Set options");
		OccurrenceMatchingResult result=driver.findImageOccurrence(fullImg,partImg,options);
		Thread.sleep(5000);
		
		

		// Analyze result
		System.out.println("Analyze result");
		System.out.println("Score: " + result.getScore());
		System.out.println("Found At: " + result.getRect());
		
		Rectangle matchRect = result.getRect();
		System.out.println("Matched at X: " + matchRect.x);
		System.out.println("Y: " + matchRect.y);
		System.out.println("Width: " + matchRect.width);
		System.out.println("Height: " + matchRect.height);

				
		if(result.getVisualization()!=null) {
			byte[] vis=Base64.getDecoder().decode(result.getVisualization());
			Files.write(new File("match_result1.png").toPath(),vis);
		}
		*/
		        
	}
	
				
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


