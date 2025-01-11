package demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class Screenshotwith3fingers {
	
	private AndroidDriver driver;
				
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("E6S8MJPFYHEUZDU8");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void Sampletest() {
		
	
		//Step 1: Fetch the center point of screen.
		System.out.println("Step1: Fetch the center point of screen.");
		
		Dimension windowsize=driver.manage().window().getSize();
			
		
		//Step 2: Calculate CenterX & CenterY Co-ordinates' 
		System.out.println("Step 2: Calculate CenterX & CenterY Co-ordinates");
		
		int centerX=windowsize.getWidth()/2;
		
		int centerY=windowsize.getHeight()/2;
		
		//Step 3: Need to Create 3 virtual fingers.
		
		System.out.println("Step 3: Need to Create 3 virtual fingers.");
		
		PointerInput middlefinger=new PointerInput(PointerInput.Kind.TOUCH, "middlefinger");
		PointerInput indexfinger=new PointerInput(PointerInput.Kind.TOUCH, "indexfinger");
		PointerInput ringfinger=new PointerInput(PointerInput.Kind.TOUCH, "ringfinger");
		
		//Step 4: Add sequence of actions to each finger
		
		System.out.println("Step 4: Add sequence of actions to each finger");
		
		//Sequence actions performed by middlefinger
		System.out.println("Sequence actions performed by middlefinger");
		Sequence middlefinger_seq=new Sequence(middlefinger, 0)
				.addAction(middlefinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerX, centerY))
				.addAction(middlefinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(middlefinger, Duration.ofMillis(50)))
				.addAction(middlefinger.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(), centerX, centerY+400))
				.addAction(middlefinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		//Sequence actions performed by indexfinger
		System.out.println("Sequence actions performed by indexfinger");
		Sequence indexfinger_seq=new Sequence(indexfinger, 0)
				.addAction(indexfinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerX-200, centerY))
				.addAction(indexfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(indexfinger, Duration.ofMillis(50)))
				.addAction(indexfinger.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(), centerX, centerY+400))
				.addAction(indexfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		//Sequence actions performed by ringfinger
		System.out.println("Sequence actions performed by ringfinger");
		Sequence ringfinger_seq=new Sequence(ringfinger, 0)
				.addAction(ringfinger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerX+200, centerY))
				.addAction(ringfinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(ringfinger, Duration.ofMillis(50)))
				.addAction(ringfinger.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(), centerX, centerY+400))
				.addAction(ringfinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		//Step 5: Perform all 3 finger's Sequence of actions at Once.
		
		System.out.println("Step 5: Perform all 3 finger's Sequence of actions at Once.");
		
		List<Sequence> list_of_actions=new ArrayList<Sequence>();
		list_of_actions.add(middlefinger_seq);
		list_of_actions.add(indexfinger_seq);
		list_of_actions.add(ringfinger_seq);
		
		((RemoteWebDriver)driver).perform(list_of_actions);	
		
		
	}
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
		
	}
	

}


