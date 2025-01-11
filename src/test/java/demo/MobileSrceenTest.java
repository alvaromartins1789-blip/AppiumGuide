package demo;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Script Details - 
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class MobileSrceenTest {
	
	private AndroidDriver driver;
	
	String AUTappPackage="com.wdiodemoapp";
	String AUTappActivity="com.wdiodemoapp.MainActivity";
	
	@BeforeTest
	public void steup() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("device14");
		cap.setAppPackage(AUTappPackage);
		cap.setAppActivity(AUTappActivity);
		cap.setNoReset(true);
		cap.setNewCommandTimeout(Duration.ofSeconds(90));
		
		
				
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
	}
	
	@Test
	public void sessionidsample() throws InterruptedException {
		Thread.sleep(5000);
		//How to get Screen Dimensions at code level.

		Dimension size = driver.manage().window().getSize();
		
		System.out.println("Width of the mobile screen - "+size.getWidth());
		System.out.println("Height of the mobile screen - "+size.getHeight());
		int MobileScreenMidPointbyWidth = (int) (size.getWidth() * 0.5);
		int MobileScreenMidPointbyHeight = (int) (size.getHeight() * 0.5);
		
		System.out.println("MobileScreenMidPointbyWidth - " +MobileScreenMidPointbyWidth);
		System.out.println("MobileScreenMidPointbyHeight - "+MobileScreenMidPointbyHeight);
		Thread.sleep(5000);
		driver.findElement(AppiumBy.accessibilityId("Login")).click();

		Thread.sleep(5000);
		WebElement element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(16)"));
		int x=element.getRect().getX();
		System.out.println("Location value of x-axis"+x);
		int y=element.getRect().getY();
		System.out.println("Location value of y-axis"+y);
		int width=element.getRect().getWidth();
		System.out.println("Width of the element Login button"+width);
		int height=element.getRect().getHeight();
		System.out.println("Height of the element Login button"+height);
		Point centerofelement=new Point((int)x+width/2, (int)y+height/2);
		System.out.println("X axis value of the center of the element" +centerofelement.getX());
		System.out.println("Y axis value of the center of the element" +centerofelement.getY());


	}
	

}

