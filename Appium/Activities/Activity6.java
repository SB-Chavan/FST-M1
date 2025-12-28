package activities;

import static org.testng.Assert.assertEquals;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6{
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	
	@BeforeClass (alwaysRun = true)
	public void setup() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Androif");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		
		URL serverURL =new URI("http://localhost:4723").toURL();
		
		driver = new AndroidDriver(serverURL,options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
		driver.get("https://training-support.net/webelements/sliders");
		
	}
	
	
	@Test
	public void volume75Test() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
		
		Dimension dims = driver.manage().window().getSize();
		
		Point start = new Point((int) (dims.getWidth() *.50), (int) (dims.getHeight() * .72) );
		Point end = new Point((int) (dims.getWidth() *.67), (int) (dims.getHeight() * .72) );
		
		System.out.println("Start: " +start);
		System.out.println("End: " +end);
		
		
		//ActionsBase.doSwipe(driver, start, end, 3000);
		ActionsBase.doSwipe(driver, start, end, 2000);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		wait =new WebDriverWait(driver, Duration.ofSeconds(3));
		
		
		String volText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text(),'%')]")).getText();
		
		
		System.out.println("The Volume % is " +volText);
		assertEquals(true, "75%");
		
	}	
	
	
	@Test
	public void volume25Test() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
		
		Dimension dims = driver.manage().window().getSize();
		
		Point start = new Point((int) (dims.getWidth() *.50), (int) (dims.getHeight() * .72) );
		Point end = new Point((int) (dims.getWidth() *.34), (int) (dims.getHeight() * .72) );
		
		ActionsBase.doSwipe(driver, start, end, 1500);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String volText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text(),'%')]")).getText();
		System.out.println("The Volume % is " +volText);
		
		assertEquals(true, "25%");
	}
	
	


	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
	

}
