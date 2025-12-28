package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	
	AndroidDriver driver;
	
	
	@BeforeClass
	public void SetUp() throws MalformedURLException, URISyntaxException {
		
        // Desired Capabilities
		
		
        UiAutomator2Options options = new UiAutomator2Options();
	
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("path/to/calculator.apk");
        options.noReset();
	
        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();
        
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
		
		
	}
	
	
	@Test
	public void additionTest() {
		
        // Perform the calculation
		
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
	
        // Find the result
	    String result = driver.findElement(AppiumBy.id("result_final")).getText();

	    // Assertion
	    Assert.assertEquals(result, "14");
	    
	    driver.findElement(AppiumBy.accessibilityId("clear")).click();
		
		
	}
	
	@Test
	public void substractTest() {
		
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("minus")).click();
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		
		Assert.assertEquals(result, "4");
		
		driver.findElement(AppiumBy.accessibilityId("clear")).click();
		
	}
	
	@Test
	public void multiplyTest() {
		
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		
		Assert.assertEquals(result, "500");
		
		driver.findElement(AppiumBy.accessibilityId("clear")).click();
	}
	
	
	@Test
	public void divisionTest() {
		
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("divide")).click();
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		
		Assert.assertEquals(result, "18");
		
		driver.findElement(AppiumBy.accessibilityId("clear")).click();
	}
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}
	
	

	
	
}
