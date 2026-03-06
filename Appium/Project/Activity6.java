package appiumProject;

import static activities.ActionsBase.doSwipe;
import static activities.ActionsBase.tap;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	Dimension dim;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		
		URL serverURL = new URI("http://localhost:4723").toURL();

		
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		
		dim = driver.manage().window().getSize();
		driver.get("https://training-support.net/webelements");
	}

	@Test(priority = 1)
	public void popupPageTest() {
		Point start = new Point((int) (dim.getWidth() * 0.6), (int) (dim.getHeight() * 0.76));
		Point end = new Point((int) (dim.getWidth() * 0.6), (int) (dim.getHeight() * 0.56));

		// Wait for page to load
		wait.until(ExpectedConditions
			.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")));

		// Scroll(Fling) to the end of the page
		doSwipe(driver, start, end, 128);

		// Wait for Login Form link and click it
		wait.until(ExpectedConditions
			.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Popups')]")))
			.click();

		// Wait for the page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id='launcher']")));
		
		// Assertion
		assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView")).getText(), "Popups");
	}
	
	@Test(priority = 2)
	public void validLoginTest() throws InterruptedException {
		// Point to tap to focus the form
		Point start = new Point((int) (dim.getWidth() * 0.6), (int) (dim.getHeight() * 0.24));
		
		// Find and click the button to launch the popup
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='launcher']")).click();
		
		// Click the username field to focus on it
		tap(driver, start);
		
		// Wait for form elements to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Submit']")));
		
		// Find the input fields and login
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))
			.sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"))
			.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Submit']")).click();

		// Wait for success message to load and get text
		String message = wait
			.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[2]")))
			.getText();
		assertEquals(message, "Welcome Back, Admin!");
	}
}

