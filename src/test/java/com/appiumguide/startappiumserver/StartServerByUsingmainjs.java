package com.appiumguide.startappiumserver;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

/**
 * Script Details - 3 Different ways To Start “Appium Server” Programmatically | By Using main.js(Appium.js) with Node.exe
 * 
 * appium-java-client version: latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class StartServerByUsingmainjs {
	
	public static void startServer() {
		
		//path of node.exe & appium main.js path & list of arguments --address & --port
		System.out.println("path of node.exe & appium main.js path & list of arguments --address & --port");
		CommandLine cmd =new CommandLine("C:\\Program Files\\nodejs\\node.exe");
					cmd.addArgument("C:\\Users\\SWETHARAMESH\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
					cmd.addArgument("--address");
					cmd.addArgument("127.0.0.1");
					cmd.addArgument("--port");
					cmd.addArgument("4723");
					
		//Launch appium server in headless mode	
					
		DefaultExecuteResultHandler handler	=new DefaultExecuteResultHandler();
		DefaultExecutor executor=new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmd,handler);
			Thread.sleep(10000);
		}catch(IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void stopServer() {
		Runtime runtime=Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
