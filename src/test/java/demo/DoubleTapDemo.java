package demo;


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
 * Script Details - Appium Gestures|How to Perform ‘Double Tap’ Gesture on a element & mobile screen-Using W3CActionsAPI
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class DoubleTapDemo {
	
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
	public void doubletaptest1() throws InterruptedException {
		//double tap on the checkbox
		driver.activateApp("io.appium.android.apis");
		Thread.sleep(5000);
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Controls")).click();
		driver.findElement(AppiumBy.accessibilityId("2. Dark Theme")).click();
		
		
		WebElement ele=driver.findElement(AppiumBy.accessibilityId("Checkbox 2"));
		
		int x=ele.getRect().getX();
		int y=ele.getRect().getY();
		int width=ele.getRect().getWidth();
		int height=ele.getRect().getHeight();
		
		Point centeroftheelement=new Point((int)(x+width/2),(int)(y+height/2));
		System.out.println("double tap on the checkbox");
		PointerInput indexfinger=new PointerInput(Kind.TOUCH,"indexfinger");
		Sequence seq=new Sequence(indexfinger, 0);
		
		seq.addAction(indexfinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centeroftheelement));
		seq.addAction(indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger, Duration.ofMillis(100)));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger, Duration.ofMillis(100)));
		seq.addAction(indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger, Duration.ofMillis(100)));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singleton(seq));		
		Thread.sleep(5000);
		
		driver.terminateApp("io.appium.android.apis");
		
	}
	
	@Test(priority=2)
	public void doubletaptest2() throws InterruptedException {
		
		//double tap on the youtube icon which on the home screen
		Thread.sleep(5000);
		System.out.println("double tap on the youtube icon which on the home screen");
		PointerInput indexfinger=new PointerInput(Kind.TOUCH,"indexfinger");
		Sequence seq=new Sequence(indexfinger, 0);
		
		seq.addAction(indexfinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), 1144, 1926));
		seq.addAction(indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger, Duration.ofMillis(100)));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger, Duration.ofMillis(100)));
		seq.addAction(indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(indexfinger, Duration.ofMillis(100)));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singleton(seq));		
		
	}
	
		
		
	@AfterClass
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}


