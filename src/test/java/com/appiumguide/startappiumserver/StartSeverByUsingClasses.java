package com.appiumguide.startappiumserver;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * Script Details - 3 Different ways To Start “Appium Server” Programmatically | By Using ‘AppiumServiceBuilder’ & ‘AppiumDriverLocalService’ Classes
 * --->Detailed Step-by-Step Coverage of All Key and Optional Methods for Both Classes
 * 
 * appium-java-client version: latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class StartSeverByUsingClasses {
	
	private static AppiumDriverLocalService service;
	
	//Method Used to start Appium Server
	public static void startServer() throws InterruptedException {
		/*
		 		 
		//Adding desired capabilities to the server session (optional)
		
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("appPackage", "com.example.app");
		caps.setCapability("appActivity", "com.example.app.MainActivity");
		
		//Customize environment variables
		
		Map<String, String> env = new HashMap<>();
		env.put("ANDROID_HOME", "C:/Users/UserName/AppData/Local/Android/Sdk");
		env.put("JAVA_HOME", "C:/Program Files/Java/jdk-17");  // Optional override
		env.put("PATH", System.getenv("PATH"));
		
		
		*/
		
		AppiumServiceBuilder builder=new AppiumServiceBuilder()
				//Set the path to node.exe
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")) 
				//Set the path to the main.js (Appium script file).
				.withAppiumJS(new File("C:\\Users\\SWETHARAMESH\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1") //Set a specific IP address for the server (e.g., "127.0.0.1").
				.usingPort(4723) //Specify the port the server should run on.
				//.usingAnyFreePort() //Automatically use any available free port.
				.withTimeout(Duration.ofMillis(50000)) //Define server startup timeout.
				.withLogFile(new File("appiumserver_logs.txt")) //Define the path for the Appium server log.
				//.withEnvironment(env)  //Customize environment variables.
				//.withCapabilities(caps) //Add desired capabilities to the server session (optional).
				.withLogOutput(System.out) //Print logs in console
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE) //Add server flags with 'Kill existing session
				.withArgument(GeneralServerFlag.USE_PLUGINS,"images") //Add server flags --use-plugins=images
				.withArgument(GeneralServerFlag.LOG_LEVEL,"info"); //Add server flags with log_level=info
				//.withArgument(GeneralServerFlag.CONFIGURATION_FILE, "path/to/caps.json");
		
		//Start appium server with default configuration
		//service=AppiumDriverLocalService.buildDefaultService();
		
		//Start appium server with set of configuration using AppiumServiceBuilder		
		service=AppiumDriverLocalService.buildService(builder);
				
		service.start();
		Thread.sleep(10000);
		
		//To check whether appium server is started or not
		if(service.isRunning()) {
			//Retrieve the URL of the running server instance
			System.out.println("Appium Server Started at : "+service.getUrl());
		}else {
			System.out.println("Failed to Start Appium Server");
		}		
				
		
	}
	
	//Method used to stop Appium Server
	public static void stopServer() {
		
		if(service!=null && service.isRunning()) {
			//Stop Appium Server
			service.stop();
			System.out.println("Appium Server Stopped");
		}else {
			System.out.println("Appium Server was not running");
		}
		
	}

}
