package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity7 {
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException{
		
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		
		driver.get("https://training-support.net/webelements/lazy-loading");
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	
	@Test
	public void test() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));

		//UI Scrollable object
		
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		
		
		List<WebElement> images = driver.findElements(AppiumBy.className("android.widget.Image"));
		
		System.out.println("Total images available on scrollbar: " + images.size());
		
		
		//Scroll to the card with Helen's post
		
		
		
		String imageText = driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(25).getChildByText(className(\"android.widget.Image\"), \"Helen\")")).getText();
		
		System.out.println("Found " + imageText + "!");
		
		
		//Get number of images shown on the screen after scrolling.

		 images = driver.findElements(AppiumBy.className("android.widget.Image"));
		
		// Print the number of images after scroll
	
		System.out.println("After scroll: " + images.size());

	
		// Assertions
	
		Assert.assertEquals(images.size(), 3);
		
		
		
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	
		
	}
	
	
	

}
