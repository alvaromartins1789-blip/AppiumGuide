package com.appiumguide.appiumconcepts;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Script Details - Appium Concepts : Simulating "Incoming Phone Calls On Android"
 * 
 * appium-java-client version: 9.3.0
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class PhoneCallTest {
	
	private AndroidDriver driver;
	private String phoneno1="1111111111";
	private String phoneno2="2222222222";
	private String phoneno3="3333333333";
	
	@BeforeClass
	public void stepup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("device14");
		cap.setAppPackage("com.wdiodemoapp");
		cap.setAppActivity("com.wdiodemoapp.MainActivity");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		
	}
	
	@AfterClass
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Execution Completed");
		}
	}
	
	@Test(priority=1)
	public void Scenarnio1() throws InterruptedException {
		//Scenario -1 receiving & decline a call
		System.out.println("Scenario -1 receiving & decline a call");
		Thread.sleep(5000); //pause to see the call effect
		driver.makeGsmCall(phoneno1, GsmCallActions.CALL);
		System.out.println(phoneno1 +" - "+"call received");
		driver.openNotifications();
		Thread.sleep(5000); //pause to see the call effect
		driver.makeGsmCall(phoneno1, GsmCallActions.CANCEL);
		System.out.println(phoneno1 +" - "+"call cancelled");
	}
	
	@Test(priority=2)
	public void Scenarnio2() throws InterruptedException {
		//Scenario -2 receiving,accept & decline a call
		System.out.println("Scenario -2 receiving,accept & decline a call");
		Thread.sleep(5000); //pause to see the call effect
		driver.makeGsmCall(phoneno2, GsmCallActions.CALL);
		System.out.println(phoneno2 +" - "+"call received");
		driver.openNotifications();
		Thread.sleep(5000); //pause to see the call effect
		driver.makeGsmCall(phoneno2, GsmCallActions.ACCEPT);
		System.out.println(phoneno3 +" - "+"call answered");
		Thread.sleep(10000); //pause to see the call effect
		driver.makeGsmCall(phoneno2, GsmCallActions.CANCEL);
		System.out.println(phoneno1 +" - "+"call cancelled");
	}
	
	@Test(priority=3)
	public void Scenarnio3() throws InterruptedException {
		//Scenario -3 receiving,accept,Hold & decline a call
		System.out.println("Scenario -3 receiving,accept,Hold & decline a call");
		Thread.sleep(5000); //pause to see the call effect
		driver.makeGsmCall(phoneno3, GsmCallActions.CALL);
		driver.openNotifications();
		System.out.println(phoneno3 +" - "+"call received");
		Thread.sleep(5000); //pause to see the call effect
		driver.makeGsmCall(phoneno3, GsmCallActions.ACCEPT);
		System.out.println(phoneno3 +" - "+"call answered");
		Thread.sleep(10000); //pause to see the call effect
		driver.makeGsmCall(phoneno3, GsmCallActions.HOLD);
		System.out.println(phoneno3 +" - "+"call kept on-Hold");
		Thread.sleep(10000); //pause to see the call effect
		driver.makeGsmCall(phoneno3, GsmCallActions.CANCEL);
		System.out.println(phoneno3 +" - "+"call cancelled");
	}
}
