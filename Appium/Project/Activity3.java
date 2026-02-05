package appiumProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {

	AndroidDriver driver;
	WebDriverWait wait;
	
	
	@BeforeTest
	public void setup() throws MalformedURLException, URISyntaxException {
		
		File appFile = new File("src/resources/ts-todo-list-v1.apk");
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setApp("path/to/ts-todo-list-v1.apk");
		//options.setApp("appFile.getAbsolutePath()");
		options.setAppPackage("com.app.todolist");   // ✅ required
	    options.setAppActivity("com.app.todolist.view.SplashActivity");
		options.noReset();
		options.getPlatformVersion();
		
		
		//Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();	
		
		
		//Intialize android driver
		
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	
		}
	
	@Test
	public void  markTaskComplete() {
		
		List<WebElement> checkboxes = driver.findElements(
		        AppiumBy.id("com.app.todolist:id/cb_task_done")
		);

		// Select first two checkboxes
		for (int i = 0; i < 2; i++) {
		    if (!checkboxes.get(i).isSelected()) {
		        checkboxes.get(i).click();
		    }
		}
		
		
		
		/// Third Task:
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * WebElement thirdTask = wait.until(
		 * ExpectedConditions.visibilityOfElementLocated( AppiumBy.androidUIAutomator(
		 * "new UiSelector().resourceId(\"com.app.todolist:id/rl_exlv_task_group_root\").instance(2)"
		 * ) ) );
		 * 
		 * 
		 * ///Long Press:
		 * 
		 * PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		 * Sequence longPress = new Sequence(finger, 1);
		 * 
		 * longPress.addAction(finger.createPointerMove( Duration.ZERO,
		 * PointerInput.Origin.fromElement(thirdTask), thirdTask.getRect().width / 2,
		 * thirdTask.getRect().height / 2 ));
		 * longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.
		 * asArg())); longPress.addAction(new Pause(finger, Duration.ofSeconds(1)));
		 * longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.
		 * asArg()));
		 * 
		 * driver.perform(List.of(longPress));
		 */		
		
		
		
	}
	
	@Test 
	public void verifyCompletetask() {
		
		//Click on More Option or 3 dots
		 wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();
		 
		//Complete task
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Completed tasks\")"))).click();
		
		
		// Wait until at least one completed task is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		        AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")));

		// Get all completed task names
		List<WebElement> taskNames = driver.findElements(
		        AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")
		);

		// Collect actual text values
		List<String> actualTaskNames = new ArrayList<>();
		for (WebElement task : taskNames) {
		    actualTaskNames.add(task.getText());
		}

		// Assertions
		Assert.assertTrue(actualTaskNames.contains("Test1"), "Task1 not found in completed list");
		Assert.assertTrue(actualTaskNames.contains("Test2"), "Task2 not found in completed list");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	}
