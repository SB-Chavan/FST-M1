package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
    
	// Driver Declaration
    AndroidDriver driver;	
    WebDriverWait wait;
    
    
    @BeforeClass
    public void Setup() throws MalformedURLException, URISyntaxException {
    	
    	UiAutomator2Options options = new UiAutomator2Options();
    	options.setPlatformName("Android");
    	options.setAutomationName("UiAutomator2");
    	options.setAppPackage("com.google.android.contacts");
    	options.setAppActivity("com.android.contacts.activities.PeopleActivity");
    	options.setCapability("autoGrantPermissions", true);
    	
    	//Server Details
    	
    	URL serverURL = new URI("http://localhost:4723").toURL();
    	driver = new AndroidDriver(serverURL, options);
    	
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	
    }
    
    
    @Test
    public void contactTest() {
    	
    	driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
    	
    	
    	
        // Wait for elements to load
    	
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
    	
        
        // Enter the details
    	
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Sagar");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Chavan");
        //driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("956188888");
	
        // Click Save
        //driver.findElement(AppiumBy.id("editor_menu_save_button")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
        
      //android.widget.TextView[@text="Save"]
	
        // Wait for contact to save
	
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
        
        
        
        // Assertion
    	
        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
	
        Assert.assertEquals(contactName, "Sagar Chavan");
	
    }
	
 
    // Tear down method
	
    @AfterClass
	
    public void tearDown() {
	
        // Close the app
	
        driver.quit();
	
    }
    
    

}
