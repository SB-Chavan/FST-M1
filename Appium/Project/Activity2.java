package appiumProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	
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
	public void setTaskDeadline() {
		
		
		WebElement element = driver.findElement(
			    AppiumBy.androidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true))"
			      + ".scrollIntoView(new UiSelector()"
			      + ".resourceId(\"com.app.todolist:id/rl_exlv_task_group_root\"))"
			    )
			);

			driver.executeScript("mobile: longClickGesture", Map.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "duration", 2000
			));
			
			
			// Wait until the element is clickable
			WebElement editTaskOption = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        AppiumBy.androidUIAutomator(
			            "new UiSelector().text(\"Edit To-Do Task\")"
			        )
			    )
			);
			
			editTaskOption.click();
			
			// Wait until the deadline element is clickable
			WebElement deadlineElement = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")
			    )
			);

			// Click on the element
			deadlineElement.click();

			// Click on date (10 January 2026)
			WebElement date10Jan = wait.until(
			        ExpectedConditions.elementToBeClickable(
			                AppiumBy.accessibilityId("10 January 2026"))
			);
			date10Jan.click();

			// Click OKAY button
			driver.findElement(AppiumBy.id("com.app.todolist:id/bt_deadline_ok")).click();
		
			//Final Submit -OKAY Button
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();
			
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	

}
