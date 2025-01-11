package demo;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
import java.util.HashMap;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class TapDemoW3CMobileGesture {
	
	private AndroidDriver driver;	
	WebElement ele;	
		
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test
	public void sampledemo() throws InterruptedException {
		
				
		driver.activateApp("io.appium.android.apis");		
		ele=driver.findElement(AppiumBy.accessibilityId("Views"));	
		
		//Tap based on elementId
		Thread.sleep(3000);
				
		System.out.println("Tap 'Views' based on elementId");
		
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",ImmutableMap.of("elementId",((RemoteWebElement) ele).getId()));

		ele=driver.findElement(AppiumBy.accessibilityId("Controls"));
		
		int x=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y=((ele.getRect().getY())+(ele.getRect().getHeight())/2);
		
		//Tap based on x & Y co-ordinates
		
		Thread.sleep(3000);
		
		System.out.println("Tap 'Controls' based on X & Y co-ordinates");
		
		((JavascriptExecutor) driver).executeScript("mobile:clickGesture",ImmutableMap.of("x",x,"y",y));
		
		ele=driver.findElement(AppiumBy.accessibilityId("2. Dark Theme"));		
		int x1=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y1=((ele.getRect().getY())+(ele.getRect().getHeight())/2);		

		Thread.sleep(3000);
		//Tap based on elementId,x & Y co-ordinates
		System.out.println("Tap '2. Dark Theme' based on elementId,x & Y co-ordinates");
		
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",ImmutableMap.of("elementId",((RemoteWebElement) ele).getId()),
				"x",x1,
				"y",y1);		
		ele=driver.findElement(AppiumBy.accessibilityId("Checkbox 2"));		
		int x2=((ele.getRect().getX())+(ele.getRect().getWidth())/2);
		int y2=((ele.getRect().getY())+(ele.getRect().getHeight())/2);		
		//Tap based on Map
				System.out.println("Tap 'Checkbox 2' based on Map");	
		HashMap<String,Object> map=new HashMap<>();
		map.put("elementId",((RemoteWebElement)ele).getId());
		map.put("x","x2");
		map.put("y","y2");
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",map);		
	}
	
			
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");

		}
		
	}
	

}


