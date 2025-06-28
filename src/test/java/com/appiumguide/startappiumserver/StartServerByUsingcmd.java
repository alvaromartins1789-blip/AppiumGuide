package com.appiumguide.startappiumserver;

import java.io.IOException;

/**
 * Script Details - 3 Different ways To Start “Appium Server” Programmatically | By Using Java Runtime() to invoke through cmd
 * 
 * appium-java-client version: latest
 * 
 * @author 'Ramesh Kodumuru' for AppiumGuide [appiumguide@gmail.com]
 */

public class StartServerByUsingcmd {
	
	public static void startServer() {
		Runtime runtime=Runtime.getRuntime();
		try {
			//Command used to start Command prompt & run the appium command
			System.out.println("Command used to start Command prompt & run the appium command");
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"appium:noreset\"\": \"\"false\"\"}\"\"");
			Thread.sleep(10000);
		}catch(IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void stopServer() {
		Runtime runtime=Runtime.getRuntime();
		try {
			//Kill or stop the appium server
			System.out.println("Kill or stop the appium server");
			runtime.exec("taskkill /F /IM node.exe");
			//Kill or stop the Command prompt
			System.out.println("Kill or stop the Command prompt");
			runtime.exec("taskkill /F /IM cmd.exe");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
