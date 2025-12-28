package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	// Declaring the driver object
	
		AppiumDriver driver;
		WebDriverWait wait;
		
		
		//Setup Function
		@BeforeClass
		public void setup() throws MalformedURLException, URISyntaxException {
			
			
			//Specify file
			
			File appFile = new File("src/resources/Calculator.apk");
			
			//Desired Capabilities
			UiAutomator2Options caps = new UiAutomator2Options();
			
			caps.setPlatformName("Android");
			caps.setAutomationName("UiAutomator2");
			caps.setApp("path/to/calculator.apk");
			caps.noReset();
			//caps.getPlatformVersion();
			
			
			//Appium server URL
			URL serverURL = new URI("http://localhost:4723").toURL();	
			
			
			//Intialize android driver
			
			driver = new AndroidDriver(serverURL, caps);
			
			
		}
		
		@Test
		public void testMethod() {
			
	        // Perform the calculation
			
	        driver.findElement(AppiumBy.id("digit_2")).click();
	        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
	        driver.findElement(AppiumBy.id("digit_5")).click();
	        driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
	        // Find the result
		
	        String result = driver.findElement(AppiumBy.id("result_final")).getText();
	        
	        // Assertion
		
	        Assert.assertEquals(result, "10");
			
			
		}
		
		
		@AfterClass
		public void tearDowm() {
			
			driver.quit();
		}
		
		


}
