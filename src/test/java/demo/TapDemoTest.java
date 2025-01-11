package demo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
import java.util.Collections;

/**
 * Script Details - Appium Gestures | How to Perform ‘Tap’ Gesture on a element & mobile screen-Using W3C Actions API
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class TapDemoTest {
	
	private AndroidDriver driver;
	
		
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(priority=1)
	public void sampleTest1() throws InterruptedException {
		
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Buttons")).click();

		WebElement ele=driver.findElement(AppiumBy.accessibilityId("Toggle"));
		
		int x=ele.getRect().getX();
		int y=ele.getRect().getY();
		int width=ele.getRect().getWidth();
		int height=ele.getRect().getHeight();
		
		
		Point Centeroftheelement=new Point((int)(x+width/2),(int)(y+height/2));
		
		System.out.println("Tap on the center of element");
		
		PointerInput middlefinger=new PointerInput(Kind.TOUCH,"middlefinger");
		Sequence seq=new Sequence(middlefinger, 0);
		
		seq.addAction(middlefinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),Centeroftheelement));
		seq.addAction(middlefinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(middlefinger,Duration.ofMillis(200)));
		seq.addAction(middlefinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(seq));	
		
		Thread.sleep(5000);
		
		driver.terminateApp("io.appium.android.apis");
		
	}
	
	@Test(priority=2)
	public void sampleTest2() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		driver.findElement(AppiumBy.accessibilityId("3D Transition")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Grand Canyon\")")).click();
		
		
		Dimension size=driver.manage().window().getSize();
		
		int centerofscreenbywidth=(int)(size.getWidth() * 0.5);
		int centerofscreenbyheight=(int)(size.getHeight() * 0.5);
		
		
		System.out.println("Tap on the center of mobile screen");
		
		
		
		PointerInput middlefinger=new PointerInput(Kind.TOUCH,"middlefinger");
		Sequence seq=new Sequence(middlefinger, 0);
		
		seq.addAction(middlefinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerofscreenbywidth, centerofscreenbyheight));
		seq.addAction(middlefinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(middlefinger,Duration.ofMillis(200)));
		seq.addAction(middlefinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(seq));	
		
		Thread.sleep(5000);
		
		driver.terminateApp("io.appium.android.apis");
	}
	
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");

		}
		
	}
	

}


