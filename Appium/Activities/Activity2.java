package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	AndroidDriver driver;
	
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
    	
        // Open the page in Chrome
	
        driver.get("https://training-support.net");
		
	}
	
	
	@Test
	public void testMethod() {
		
		String pageHeading = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		assertEquals(pageHeading, "Training Support");
		
		
		driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		
		
		pageHeading = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		assertEquals(pageHeading, "About Us");
		

		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}
	

	
	
	

}
