package demo;

import org.testng.annotations.Test;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class BatteryInfoDemo {
	
	private AndroidDriver driver;
	
		
	@BeforeTest
	public void setup() throws IOException{
			
		UiAutomator2Options capabilities=new UiAutomator2Options();
		capabilities.setPlatformName("android");
		capabilities.setAutomationName("uiautomator2");
		capabilities.setDeviceName("Pixel8Pro");
							
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
	}
	
	@Test
	public void test1() throws IOException, InterruptedException {
		Scanner scan =new Scanner(System.in);
		
		for(int i=1;i<=5;i++) {
			
			
			System.out.println("----------------------starting---------------------------------------");
			System.out.println("Battery level before update -"+driver.getBatteryInfo().getLevel());
			System.out.println("Battery state before update -"+driver.getBatteryInfo().getState());	
			System.out.println("------------------------------------------------------------");
			System.out.println("please enter battery level");	
			String adb_level=scan.nextLine();
			System.out.println("please enter battery state");	
			String adb_state=scan.nextLine();
			
			System.out.println("------------------------------------------------------------");
			
			Runtime.getRuntime().exec("adb shell dumpsys battery set level " +adb_level);
			
			Runtime.getRuntime().exec("adb shell dumpsys battery set status "+adb_state);
			
			Thread.sleep(5000);
			
			System.out.println("------------------------------------------------------------");		
			System.out.println("Battery level after updating -"+driver.getBatteryInfo().getLevel());
			System.out.println("Battery state after updating -"+driver.getBatteryInfo().getState());
		
			
			
		}
	}
	
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			//driver.quit();
			
		}
		
	}
	

}



