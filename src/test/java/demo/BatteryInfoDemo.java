package demo;
import org.testng.annotations.Test;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.Scanner;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

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
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}



