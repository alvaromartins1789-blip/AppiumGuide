package demo;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;

/**
 * Script Details - #7 | (Part-2)-Perform ‘FlingGesture’ based on Area(fling bounding area & direction - left/right
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class FlingAreaDemo {
	
	private AndroidDriver driver;
	int centerx,centery,widthx,heighty;
	
			
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.activateApp("net.organicbazar");
		Thread.sleep(5000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)")).click();
		Thread.sleep(3000);
		//perform fling gesture direction to right
		System.out.println("perform fling gesture direction to right");
		
		WebElement element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
		
		centerx=(int)(element.getRect().getWidth()*0.5);
		centery=(int)(element.getRect().getHeight()*0.5);
		
		widthx=(int)(element.getRect().getWidth()*0.2);
		heighty=(int)(element.getRect().getHeight()*0.5);
		
		((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
				"left",centerx,
				"top",centery,
				"width",widthx,
				"height",heighty,
				"direction","right"));
		
		Thread.sleep(3000);
		
		centerx=(int)(element.getRect().getWidth()*0.5);
		centery=(int)(element.getRect().getHeight()*0.5);
		
		widthx=(int)(element.getRect().getWidth()*0.8);
		heighty=(int)(element.getRect().getHeight()*0.5);
		
		//perform fling gesture direction to left
		System.out.println("perform fling gesture direction to left");
		
		int speedvalue=(int)(500*2.625);
		
		((JavascriptExecutor)driver).executeScript("mobile: flingGesture",ImmutableMap.of(
				"left",centerx,
				"top",centery,
				"width",widthx,
				"height",heighty,
				"direction","left",
				"speed",speedvalue));		
				
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}


