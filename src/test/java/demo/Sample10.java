package demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileOutputStream;
import java.net.URL;



public class Sample10 {
	
	private AndroidDriver driver;
					
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options cap=new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("uiautomator2");
		cap.setDeviceName("device-13");
		
					
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
		
	@Test
	public void test() throws InterruptedException, IOException {
		
		/*
		File imageFile = new File(System.getProperty("user.dir")+"/Beverages.png");
        byte[] fileContent = Files.readAllBytes(imageFile.toPath());
        String base64Image = Base64.getEncoder().encodeToString(fileContent);
        */
		System.out.println("started");
		
		File file = new File(System.getProperty("user.dir")+"/Beverages.png");
		byte[] fileContent=Files.readAllBytes(file.toPath());
        String base64Image = Base64.getEncoder().encodeToString(fileContent);		
		

        // Use AppiumBy.image()
        WebElement imageElement = driver.findElement(AppiumBy.image(base64Image));
        imageElement.click();
        System.out.println("stopped");
       
		         /* 
	            // Step 2: Compress local folder to zip
	            String localFolderPath = "path/to/local/folder";
	            String zipPath = "folder.zip";
	            File zipFile = new File(zipPath);
	            zipFolder(new File(localFolderPath), zipFile);

	            // Step 3: Read and push folder (as zip Base64)
	            byte[] zipBytes = Files.readAllBytes(zipFile.toPath());
	            String base64Zip = Base64.getEncoder().encodeToString(zipBytes);	            
	            //driver.pushFolder("/data/local/tmp/testfolder", base64Zip);
	            System.out.println("Folder pushed successfully.");
				*/	                

	        
		   
	}
		// Utility to zip a folder
		    public static void zipFolder(File sourceFolder, File zipFile) throws Exception {
		        try (FileOutputStream fos = new FileOutputStream(zipFile);
		             java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(fos)) {
		            zipFiles(sourceFolder, sourceFolder.getName(), zos);
		        }
		    }

		    private static void zipFiles(File fileToZip, String fileName, java.util.zip.ZipOutputStream zos) throws Exception {
		        if (fileToZip.isHidden()) return;
		        if (fileToZip.isDirectory()) {
		            if (!fileName.endsWith("/")) fileName += "/";
		            zos.putNextEntry(new java.util.zip.ZipEntry(fileName));
		            zos.closeEntry();
		            for (File childFile : fileToZip.listFiles()) {
		                zipFiles(childFile, fileName + childFile.getName(), zos);
		            }
		            return;
		        }
		        try (java.io.FileInputStream fis = new java.io.FileInputStream(fileToZip)) {
		            java.util.zip.ZipEntry zipEntry = new java.util.zip.ZipEntry(fileName);
		            zos.putNextEntry(zipEntry);
		            byte[] bytes = new byte[1024];
		            int length;
		            while ((length = fis.read(bytes)) >= 0) {
		                zos.write(bytes, 0, length);
		            }
		        }
		    }
		
		
		
			
		
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
			System.out.println("Test Completed");
		}
		
	}
	

}


