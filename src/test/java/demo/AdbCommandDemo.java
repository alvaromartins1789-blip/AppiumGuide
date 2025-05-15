package demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


public class AdbCommandDemo {
	
	private AndroidDriver driver;
					
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("device14");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
		
	@Test
	public void test() throws InterruptedException, IOException {
		
			    
        	
        // Step 2: .pushFile(remotePath, base64Data)        
        File file = new File(System.getProperty("user.dir")+"/3fingers.png");
        byte[] fileContent = Files.readAllBytes(file.toPath());
        byte[] base64String = Base64.getEncoder().encode(fileContent);

        driver.pushFile("/sdcard/download/pushed_3fingers_base64.png", base64String);
        System.out.println("File pushed from base64 string.");
		
        //.pullFile(remotePath)
        byte[] pulledBase64 = driver.pullFile("/sdcard/download/pushed_3fingers_base64.png");
        Files.write(Paths.get("pushed_3fingers_base64.png"), pulledBase64);
        System.out.println("File pulled and saved as pushed_3fingers.png");
		}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


