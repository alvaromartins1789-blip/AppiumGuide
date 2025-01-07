package demo1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class Test5 {
	
	private AndroidDriver driver;
	 String app_package="com.fastaguser";
		
	@BeforeTest
	public void stepup1() throws MalformedURLException {
		UiAutomator2Options cap =new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("Pixel8Pro");
		
				
		driver=new AndroidDriver(new URL("http://127.0.0.1:10000"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	@Test
	public void sessionidsample() throws InterruptedException {
		Thread.sleep(5000);
		driver.activateApp(app_package);
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(6)")).click();
		driver.findElement(AppiumBy.id("com.fastaguser:id/vehicle_id_txt")).sendKeys("1234");
		driver.findElement(AppiumBy.id("com.fastaguser:id/btn_submit")).click();
		
		
	}
	
	@AfterTest
	public void teardown1() {
		if(driver!=null) {
			//driver.quit();
			System.out.println("Test Completed");
		}
	}
	

}

