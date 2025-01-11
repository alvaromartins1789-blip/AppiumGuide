package demo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import java.time.Duration;
import java.util.Arrays;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class W3CActionsAPITest {
	
	private AndroidDriver driver;
	
	String app_package="io.appium.android.apis";
	
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(priority=1)
	public void W3CActionsAPISample1() {
		
		driver.activateApp(app_package);
		
		driver.findElement(AppiumBy.accessibilityId("Graphics")).click();
		
		driver.findElement(AppiumBy.accessibilityId("FingerPaint")).click();
		
		Dimension size=driver.manage().window().getSize();
		
		int startX=(int)(size.getWidth() * 0.5);
		int startY=(int)(size.getHeight() * 0.2);
		
		
		int endX=(int)(size.getWidth() * 0.5);
		int endY=(int)(size.getHeight() * 0.8);
		
		
		//creating a virtual finger
		PointerInput indexfinger=new PointerInput(Kind.TOUCH,"indexfinger");
		//Container
		Sequence seq=new Sequence(indexfinger, 1);
		
		seq.addAction(indexfinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), startX, startY));
		seq.addAction((indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())));
		seq.addAction(indexfinger.createPointerMove(Duration.ofSeconds(10), PointerInput.Origin.viewport(), endX, endY));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(seq));
		
	}
	
	@Test(priority=2)
	public void W3CActionsAPISample2() {
		
		Dimension size=driver.manage().window().getSize();
		
		int startX=(int)(size.getWidth() * 0.2);
		int startY=(int)(size.getHeight() * 0.5);
		
		
		int endX=(int)(size.getWidth() * 0.8);
		int endY=(int)(size.getHeight() * 0.5);
		
		
		//creating a virtual finger
		PointerInput indexfinger=new PointerInput(Kind.TOUCH,"indexfinger");
		//Container
		Sequence seq=new Sequence(indexfinger, 1);
		
		seq.addAction(indexfinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), startX, startY));
		seq.addAction((indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())));
		seq.addAction(indexfinger.createPointerMove(Duration.ofSeconds(20), PointerInput.Origin.viewport(), endX, endY));
		seq.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(seq));
		
	}
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.terminateApp(app_package);
			driver.quit();
			System.out.println("Test Execution Completed");

		}
		
	}
	

}


